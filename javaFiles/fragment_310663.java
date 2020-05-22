for (int i=0; i< threads.length; i++) {
    final int foo = i;
    threads[i] = new Thread(new Runnable() {
         public void run() {
             // Use foo here
         }
    });
}