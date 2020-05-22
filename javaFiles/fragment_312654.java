class MyClass {

   String s = "";//can't be used in a static method
   static String t = "";//can be used in a static method

   public static void main(String[] args) {
       testOne();//this will break
       testTwo();//this is valid
       MyClass myClass = new MyClass()
       myClass.testOne();//this is valid

       System.out.println(s);//this will break
       System.out.println(t);//this will not break
       System.out.println(myClass.s);//this will not break
   }

   public void testOne() { }
   public static void testTwo() { }

}