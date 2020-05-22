public bgImagePanel(BorderLayout b) {
    super(b);
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage("bgimage1.jpg");
    mt.addImage(bgimage, 0);
    try {
       mt.waitForAll();
    } catch (InterruptedException e) {}
}