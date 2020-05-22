public static void main(String[] args) throws InterruptedException {
       SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
       int i = 0;
       while (true) {
           System.out.println(format.format(new Date()) + " Hello " + i);
           i++;
           Thread.sleep(20);
       }
   }