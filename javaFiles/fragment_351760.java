public void methodBla(){
 try{
     try{
         system.out.println(2/0);
     catch(ArithmeticException e){
         throw new MyArithmeticException(e);
     }
 }
 catch(MyArithmeticException me){
      system.out.println("Error: My exception");
 }
 catch(Exception a){
      system.out.println("Error: general exception");
 }
}