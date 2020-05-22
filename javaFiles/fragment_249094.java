public class URLDrawable extends BitmapDrawable {
    protected Drawable drawable;
     @Override
    public void draw(Canvas canvas) {
        if(drawable != null) {
            drawable.draw(canvas);
        }
    }
}