package test;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class TypeParameterTest {

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExpectedType {
        public Class<?> value();
    }

    public static interface IObjectA {}

    public static class ObjectA_DTO implements IObjectA {}

    public static class ObjectA_Entity implements IObjectA {}

    public static class SomeServiceImpl {
        public @ExpectedType(ObjectA_DTO.class) IObjectA doSomething(@ExpectedType(ObjectA_Entity.class) IObjectA obj) {
            return (ObjectA_Entity) obj;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Method m = SomeServiceImpl.class.getMethod("doSomething", IObjectA.class);
        AnnotatedType returnType = m.getAnnotatedReturnType();
        Annotation returnTypeAnnotation = returnType.getAnnotation(ExpectedType.class);
        System.out.println(returnTypeAnnotation);

        AnnotatedType[] parameters = m.getAnnotatedParameterTypes();
        for (AnnotatedType p : parameters) {
            Annotation parameterAnnotation = p.getAnnotation(ExpectedType.class);
            System.out.println(parameterAnnotation);
        }
    }
}