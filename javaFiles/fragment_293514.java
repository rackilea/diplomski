public float parseFloat(String s){
   float f = 0.0f;
   try{
      SomeOtherClass.doStuffWhichFailsWithRuntimeException();
      return f;
   }
   catch(NumberFormatException nfe){
       // will not run, because the thrown exception is not of type NumberFormatException
   }catch(Exception e){
       // any other failure besides NumberFormatException
       // considered bad practice: If you do not know what fails, do not try to recover from it, it's most likely very bad.
      return f;
   }
   finally { 
      // this will run after the catch block was run
      System.out.println("finally");  
   }

   // theoretically reachable, but compiler does not allow it because he cannot check it.
   //return f ;
}