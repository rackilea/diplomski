Public class MyClass{
   public static ArrayList<String> OnThings = new ArrayList<String>(Arrays.asList("Thing1", "Thing2"));
   public static ArrayList<String> OffThings = new ArrayList<String>(Arrays.asList("Thing3"));
}

protected void Test1{
   /**Below method iterates both arrays and turns things on or off**/
   turnThingsOnOrOff(MyClass.OnThings, MyClass.OffThings)
   /**Do a bunch of testing here**/
}

protected void Test2{
   /**This particular test I want to turn off Thing 1**/
   OnThings.Remove{"Thing1"}
   OffThings.Add{"Thing1"}
   turnThingsOnOfOff(MyClass.OnThings, MyClass.OffThings)
   /**Do a bunch of testing here**/
}