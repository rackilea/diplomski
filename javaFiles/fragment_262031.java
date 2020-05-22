MultiThreadExample th1=new MultiThreadExample();
    MultiThreadExample th2=new MultiThreadExample();
    th1.start();
   try {
    th1.join();
} catch (InterruptedException ex) {
    System.out.println(ex.getMessage());
}
    th2.start();