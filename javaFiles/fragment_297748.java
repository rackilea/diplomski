public class exClass {
   public int aVariable;

   public exClass()
   {
      othClass.aMethod(this);
   }
}

public class othClass{

   static void aMethod(exClass x)
   {
      x.aVariable = 0; //or call a setter if you want to keep the member private
   }
}