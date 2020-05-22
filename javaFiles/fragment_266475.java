void run() {
   while (true) {
       synchronized (lock) {
           MY_INT++;
           System.out.println("1 : " + MY_INT);
       }
   }
}