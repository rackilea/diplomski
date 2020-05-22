public Image loadImage(String name) {
   Image img = null;
   MediaTracker tracker = new MediaTracker(myPanel); // pass the panel from ctor
   img = Toolkit.getDefaultToolkit().getImage(ImageLoader.class.getResource(name));
   tracker.addImage(img, 0);
   try {
      tracker.waitForID(0);
   } catch (InterruptedException e) {
      e.printStackTrace();
   }

   return img;
}