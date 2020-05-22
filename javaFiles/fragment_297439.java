public MyClass
{
   int theDate = 9;
   String day = "Tuesday";

   // This would return the default values of the class
   public MyClass()
   {
   }

   // Where as this would return the new String
   public MyClass (String aDiffDay)
   {
      day = aDiffDay;
   }
}