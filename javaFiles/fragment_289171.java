public class BgCropScreen extends MainScreen {

   public BgCropScreen() {
      super(MainScreen.NO_VERTICAL_SCROLL);  // <<<<<< THIS IS THE CRITICAL LINE !!!!!!

      VerticalFieldManager bgManager = new VerticalFieldManager(Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR | Manager.USE_ALL_WIDTH | Manager.USE_ALL_HEIGHT) {
         // to draw the background image.
         public void paint(Graphics graphics) {
            graphics.drawBitmap(0, 0, Display.getWidth(), Display.getHeight(), backgroundBitmap, 0, 0);
            super.paint(graphics);
         }                
      };
      this.add(bgManager);