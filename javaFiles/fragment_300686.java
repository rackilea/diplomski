private void longMethod(Object arg) {
   arg = new Object();  // Line 1
   Thread.sleep(1000 * 60 * 60);
   arg = null;  // now the object created in line 1 is eligible for GC

}