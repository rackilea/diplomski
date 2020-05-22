void method1() throws Exception{
//
}

void method2() throws Exception{
//
}

   void finalmethod(){
        try{
          method1();

          method2();

        }catch(InputMismatchException e){
                  throw customExcpetion("custommessage1");
        }catch(Exception e){
            throw customExcpetion("custommessage2");
        }
    }