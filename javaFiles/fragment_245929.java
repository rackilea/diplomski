public class Test {

    public static void main(String args[]) {
        Test t = new Test();
        String packageName = t.getClass().getPackage().getName();
        System.out.println("Package Name = " + packageName);

        //and without any instance:
        String packageName2 = Test.class.getPackage().getName();
        System.out.println("Package Name no instance  = " + packageName2);      }
}