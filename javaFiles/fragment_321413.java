public class CustomBitmapButtomField extends ButtonField{

   private  Bitmap activeBtn = null;
   private  Bitmap normalBtn = null;
   private  Bitmap focusBtn = null;

   private int btnHeight = 0;
   private int btnWidth = 0;


   public CustomBitmapButtomField(Bitmap normal,Bitmap focus,Bitmap active) {
   activeBtn = active;
   normalBtn = normal ;
   focusBtn = focus;
   btnWidth = normalBtn.getWidth();
   btnHeight = normalBtn.getWidth();
   setMargin(0, 0, 0, 0);
   setPadding(0,0,0,0);
   setBorder(BorderFactory.createSimpleBorder(new XYEdges(0, 0, 0, 0)));
   setBorder(VISUAL_STATE_ACTIVE, BorderFactory.createSimpleBorder(new XYEdges(0, 0, 0, 0)));
   setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));   
   }

   protected void paint(Graphics graphics) {
     Bitmap bitmap = null;
     switch (getVisualState()) {
    case VISUAL_STATE_NORMAL:
        bitmap = normalBtn;
        break;
    case VISUAL_STATE_FOCUS:
        bitmap = focusBtn;
        break;
    case VISUAL_STATE_ACTIVE:
        bitmap = activeBtn;
        break;
    default:
        bitmap = normalBtn;
        break;
    }
    graphics.drawBitmap(0, 0, bitmap.getWidth(), bitmap.getHeight(), bitmap, 0, 0);
}

   public int getPreferredWidth() {
    return btnWidth;
}
   public int getPreferredHeight() {
    return btnHeight;
}
   protected void layout(int width, int height) {
    setExtent(btnHeight,btnHeight);
}
 }