public class Bullet {

    private float x;
    private float y;
    private Paint paint;

    Bitmap bullet;

    public Bullet(float x, float y, Context context) {
        this.x = x;
        this.y = y;

        bullet = BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_beam);
    }
    public void tick() {
        y -= 30;
    }
    public void render(Canvas canvas) {
        canvas.drawBitmap(bullet, x, y,null);
    }
}