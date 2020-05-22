public class MySurface extends SurfaceView {

    private SurfaceHolder surfaceHolder;
    private Bitmap bmpIcon;

    public MySurface(Context context) {
        super(context);
        init();
    }

    public MySurface(Context context,
                     AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurface(Context context,
                     AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    private void init() {
        surfaceHolder = getHolder();

        bmpIcon = getBitmapFromVectorDrawable(getContext(), R.drawable.icon);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas canvas = holder.lockCanvas(null);
                drawSomething(canvas);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder,
                                       int format, int width, int height) {
                // TODO Auto-generated method stub

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // TODO Auto-generated method stub

            }
        });
    }

    protected void drawSomething(Canvas canvas) {
        canvas.drawColor(Color.RED);
        if (bmpIcon != null) {
            canvas.drawBitmap(bmpIcon,
                    getWidth() / 2, getHeight() / 2, null);
        }

    }

}