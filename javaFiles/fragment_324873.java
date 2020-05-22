public static void main(String[] args) {
  try {
     MultiServer2 multiServer = new MultiServer2();
     new Thread(multiServer).start();  // this runs the runnable
  } catch (IOException e) {
     e.printStackTrace();
  }
}