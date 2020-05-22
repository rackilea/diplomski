public class ClassDemo {

   public static void main(String[] args) {

     try {
        Class cls = Class.forName("ClassDemo");

        // returns the ClassLoader object
        ClassLoader cLoader = cls.getClassLoader();

        /* returns the Class object associated with the class or interface 
        with the given string name, using the given classloader. */
        Class cls2 = Class.forName("java.lang.Thread", true, cLoader);       

        // returns the name of the class
        System.out.println("Class = " + cls.getName());
        System.out.println("Class = " + cls2.getName()); 
     }
     catch(ClassNotFoundException ex) {
        System.out.println(ex.toString());
     }
   }
}