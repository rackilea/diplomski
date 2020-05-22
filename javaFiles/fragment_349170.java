public class BackgroundColorDrawable extends Drawable {

    private Paint paint;
    private RectF rectF;
    private float cornerRadius = 20f;
    private float borderThickness = 3.5f;
    private int insetColour = Color.GREEN;

    public BackgroundColorDrawable() {

        paint = new Paint();
        paint.setAntiAlias(true);
        rectF = new RectF();
    }

    public void setInsetColour(int insetColour) {
        this.insetColour = insetColour;
        invalidateSelf();
    }

    public void setBorderThickness(float borderThickness) {
        this.borderThickness = borderThickness;
        invalidateSelf();
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {

        paint.setColor(Color.GRAY);
        rectF.set(0f, 0f, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);

        paint.setColor(Color.WHITE);
        rectF.set(borderThickness, borderThickness, canvas.getWidth() - borderThickness, canvas.getHeight() - borderThickness);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);

        paint.setColor(insetColour);
        rectF.set(borderThickness, borderThickness, 60f, canvas.getHeight() - borderThickness);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);

        paint.setColor(Color.WHITE);
        rectF.set(30f, borderThickness, 60f, canvas.getHeight() - borderThickness);
        canvas.drawRect(rectF, paint);
    }

    @Override
    public void setAlpha(int alpha) { /* to implement */ }

    @Override
    public void setColorFilter(ColorFilter colorFilter) { /* to implement */}

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}