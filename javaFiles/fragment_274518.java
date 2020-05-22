import java.lang.reflect.Field; 
import java.lang.reflect.Method; 
import java.lang.reflect.InvocationTargetException; 

public class Hacker {

    private static final Object[] EMPTY = {};

    public void reflect(Object instance)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = instance.getClass();

        while (cls != null && cls != Object.class) {
            System.out.println("From class: " + cls.getName());

            // Print all the method names & execution result
            Method methods[] = cls.getDeclaredMethods(); 
            System.out.println("Access all the methods"); 
            for (int i = 0; i < methods.length; i++) { 
                System.out.println("Method Name: " + methods[i].getName());
                System.out.println("Return type: " + methods[i].getReturnType());
                methods[i].setAccessible(true);
                System.out.println(methods[i].invoke(instance, EMPTY) + "\n");
            }

            //  Print all the field names & values
            Field fields[] = cls.getDeclaredFields();
            System.out.println("Access all the fields");
            for (int i = 0; i < fields.length; i++){ 
                System.out.println("Field Name: " + fields[i].getName()); 
                fields[i].setAccessible(true); 
                System.out.println(fields[i].get(instance) + "\n"); 
            }

            // Go to the base class
            cls = cls.getSuperclass();
        }
    }

    public static void main(String[] args){

        Hacker newHacker = new Hacker();

        try { 
            newHacker.reflect(new Secret());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}