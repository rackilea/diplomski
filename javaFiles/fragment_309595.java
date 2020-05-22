public void run() {
  synchronized(CommonClass.class){
    for (int i = 0; i < 10; i += 2) {
     System.out.println("Even :" + num);
    }
  }
}