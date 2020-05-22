import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class IntrospectorTest {

    @Test
    public void test() throws IntrospectionException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {

        SampleClass sampleClass = new SampleClass();

        sampleClass.setA("value for a");
        sampleClass.setB("value for b");
        sampleClass.setC("value for c");
        sampleClass.setD("value for d");
        sampleClass.setE("value for e");
        sampleClass.setF("value for f");

        int withValue = 0;

        PropertyDescriptor[] descriptors = Introspector.getBeanInfo(SampleClass.class, Object.class).getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : descriptors) {
            Object value = new PropertyDescriptor(propertyDescriptor.getName(), SampleClass.class).getReadMethod().invoke(sampleClass);
            if (value!=null) {
                withValue++;
                System.out.println(propertyDescriptor.getName() + ": " + value);    
            }
        }

        if (descriptors.length == withValue || withValue == 0) {
            System.out.println("valid");
        }else{
            System.err.println("Invalid!!");
        }
    }
}