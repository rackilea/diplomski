class Test {
   int count;

   int test(String[] arg) {
       for (int i = 0; i < getLength(arg); i++) {
           // ...
       }
       return count;
   }

   int getLength(String[] arg) {
       count++;
       return arg.length;
   }
}