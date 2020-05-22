MediaTracker mt=new MediaTracker(this);
mt.addImage(image, 0);
try {
  mt.waitForID(0);
}
catch (InterruptedException me) { System.out.println("error); }