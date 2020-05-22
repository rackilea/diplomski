private int[] intArray = new int[]{4, 3, 6, 2, 5};
public void myMethod() {
  try {
    int x = 0;
    for (int i = 0; i < intArray.length; i++) {
      x = intArray[i];
      Thread.sleep(x);
      // my custom things happen here after the thread sleep
   }
  } catch (InterruptedException ex) {
    Logger.getLogger(RoutePanel.class.getName()).log(Level.SEVERE, null, ex);
  }
}