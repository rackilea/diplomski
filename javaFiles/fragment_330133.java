package mawi12345;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void printAnnotations(Class<?> clazz) {
        // array of methods
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("found "+methods.length+" methods");
        for (int i=0; i<methods.length; i++) {
            // get the annotations of this method
            Annotation[] methodAnnotations = methods[i].getAnnotations();
            // if you only wont to check for one annotation use getAnnotation(Class<T>)

            for (Annotation methodAnnotation : methodAnnotations) {
                System.out.println(methodAnnotation);
            }
            // get the parameter annotations (2d array) 
            Annotation[][] parameterAnnotations = methods[i].getParameterAnnotations();
            // get an array of parameters
            Class<?>[] parameters = methods[i].getParameterTypes();
            for(int x=0; x<parameterAnnotations.length; x++) {
                Class<?> parameter = parameters[x];
                for(Annotation annotation : parameterAnnotations[x]){
                    // print the parameter name and his annotation
                    System.out.println(parameter.getName() + " " + annotation);
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create Test object
        Test test = new Test();
        // get the class
        Class<?> clazz = test.getClass();
        System.out.println("Class Test");
        // print annotations
        printAnnotations(clazz);
        System.out.println();

        // get the interfaces of the class
        Class<?>[] interfaces = clazz.getInterfaces();

        System.out.println("found "+interfaces.length+" interfaces");
        // print annotations for each interface
        for (Class<?> type : interfaces) {
            System.out.println(type);
            printAnnotations(type);
        }

    }

}