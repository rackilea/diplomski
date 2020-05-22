public class Enemy {
  private Bitmap bitmap;
  private Canvas canvas;
  private Context context;
  private float x, y;

  public Enemy(Canvas canvas, Context context) {
    bitmap = BitmapFactory.decodeResource(
        context.getResources(), R.drawable.ic_launcher);
    x = (float) (Math.random() * 200);
    y = (float) (Math.random() * 200);
  }

  public void draw() {
    canvas.drawBitmap(bitmap, x, y, null);
  }

  public void printCoordinates() { // just used for printing
    System.out.println("x = " + x + " / y = "+ y);
  }
}