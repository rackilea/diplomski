public void run() {
   while(true){
        String event = sc.nextLine();
        try {
          queue.put(event); // thread will block here
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
}