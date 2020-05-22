public class Main {
    public static void main(String[] args) {
      clazz c = new clazz();
        c.display();
    }
}
   class Demo
   {
      // Apply superclass's logic here
   }

    // sub class
class clazz extends Demo {
   public void display()
   {
       Demo val1 = new Demo();
      clazz val2 = new clazz();
      Class cls;
      cls = val1.getClass();
      System.out.println("Super class name = " + cls.getName());
      /* returns the superclass of the class(superClass) represented
         by this object */
      cls = cls.getSuperclass();
      System.out.println("Super is inherited by another class " + cls.getName());
      cls = val2.getClass();
      System.out.println("child Class Name " + cls.getName());
      /* returns the superclass of the class(subClass) represented
         by this object */
      cls = cls.getSuperclass();
      System.out.println("Child class extended by " + cls.getName());
   }
}