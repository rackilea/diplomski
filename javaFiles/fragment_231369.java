public int getOne() {
   return 1;
}

public int getA(int a) {
   /*
   what you do here is call getOne(). The method will be called,
   and it will produce some result, but this result will not be persisted
   in any way, you will just go to the next line where the original a's
   value will be returned
    */
   getOne(); 
   return a;


}