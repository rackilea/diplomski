public class BorderDrawable extends BitmapDrawable {

    private static final int BORDER_WIDTH = 10;
    private final int[] GRADIENT_COLORS = {Color.BLUE, Color.GREEN, Color.RED};
    Paint borderPaint;

    public BorderDrawable(Resources res, Bitmap bitmap) {
        super(res, bitmap);
        this.borderPaint = new Paint();
        borderPaint.setStrokeWidth(BORDER_WIDTH);
        borderPaint.setStyle(Paint.Style.STROKE);

        // set border gradient
        Shader shader = new LinearGradient(0, 0, 0, getBounds().bottom, GRADIENT_COLORS, null,  Shader.TileMode.CLAMP);
        borderPaint.setShader(shader);

        // or the border color
        // borderPaint.setColor(Color.GREEN);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        // draw
        canvas.drawRect(getBounds(), borderPaint);
    }
}