import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class M1 {

    public static class PojoBase {
        int property;
        String strProp;
    }



    public static class Intereptor {

        private final String fieldName;
        private final PojoBase pojo;
        public Intereptor(PojoBase pojo, String fieldName) {
            this.pojo = pojo;
            this.fieldName = fieldName;
        }
        @RuntimeType
        public Object intercept(@RuntimeType Object value) throws NoSuchFieldException, IllegalAccessException {

            Field field = pojo.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(pojo, value);
            return value;
        }
    }



    public static void main(String... args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
            PojoBase origBean = new PojoBase();
            PojoBase destBean = new PojoBase();

            origBean.property = 555666;
            origBean.strProp = "FooBar";

        DynamicType.Builder<Object> stub = new ByteBuddy()
            .subclass(Object.class);

        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<Object> dynamic = stub.defineMethod("getProperty", Integer.TYPE, Opcodes.ACC_PUBLIC).intercept(FixedValue.value(origBean.property))
                .defineMethod("setProperty", Void.TYPE, Opcodes.ACC_PUBLIC).withParameters(Integer.TYPE).intercept(MethodDelegation.to(new Intereptor(destBean, "property")))
                .defineMethod("getStrProp", String.class, Opcodes.ACC_PUBLIC).intercept(FixedValue.value(origBean.strProp))
                .defineMethod("setStrProp", Void.TYPE, Opcodes.ACC_PUBLIC).withParameters(String.class).intercept(MethodDelegation.to(new Intereptor(destBean, "strProp")));

        Class<?> dynamicType =     dynamic.make()
                .load(M1.class.getClassLoader())
                .getLoaded();


            Object readerObject = dynamicType.newInstance();
            Object writterObject = dynamicType.newInstance();


            BeanUtils.copyProperties(readerObject, writterObject);
            System.out.println("Out property:" + destBean.property);
            System.out.println("Out strProp:" + destBean.property);
    }



}