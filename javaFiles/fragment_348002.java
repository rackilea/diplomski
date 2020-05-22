public class GridView extends View {

    private static final String TAG = GridView.class.getSimpleName();

    BitmapDrawable bm;
    Bitmap bitmap;

    GradientDrawable gd;
    int offsetX = 0;
    int offsetY = 0;
    private int width = 16;


    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setWidth(int w) {
        width = w;
        render();
        invalidate();
    }


    private void render() {
        setShape();
        if (gd != null) {
            bitmap = drawableToBitmap(gd);
            bm = new BitmapDrawable(getResources(), bitmap);
            bm.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            bm.setBounds(0, 0, width, width);
        }
    }

    Point startPt;
    LatLng savedAlignmentPt;


    public void setAlignment(LatLng alignmentPt, Projection p, VisibleRegion vr) {

        if (alignmentPt == null) {
            alignmentPt = savedAlignmentPt;
        }

        if (alignmentPt == null) {
            return;
        }
        // the alignment point is the a corner of a grid square "near" the center of the screen
        savedAlignmentPt = alignmentPt;

        // compute how many screen pixels are in 3 meters using alignment point
        startPt =  p.toScreenLocation(alignmentPt);
        LatLng upperRight = SphericalUtil.computeOffset(alignmentPt, 3, 90);
        Point upperRtPt = p.toScreenLocation(upperRight);

        int pixelsOf3meters = upperRtPt.x - startPt.x;

        // don't draw grid if too small
        if (pixelsOf3meters < 16) {
            return;
        }

        setWidth(pixelsOf3meters);

        // startPt is screen location of alignment point
        offsetX = (pixelsOf3meters - (startPt.x % pixelsOf3meters));
        offsetY = (pixelsOf3meters - (startPt.y % pixelsOf3meters));

        invalidate();

    }

    private void setShape() {
        int left, right, top, bottom;
        gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setSize(width, width);
        gd.setStroke(2, Color.argb(0xff, 0xcc, 0x22, 0x22));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect = canvas.getClipBounds();


        final int cWidth = canvas.getWidth();
        final int cHeight = canvas.getHeight();

        if (bm == null) {
            return;
        }

        final Rect bmRect = bm.getBounds();
        if (bmRect.width() <= 8 || bmRect.height() <= 8) {
            return;
        }


        final int iterX = iterations(cWidth, -offsetX, bmRect.width());
        final int iterY = iterations(cHeight, -offsetY, bmRect.height());

        canvas.translate(-offsetX, -offsetY);

        for (int x = 0; x < iterX; x++) {
            for (int y = 0; y < iterY; y++) {
                bm.draw(canvas);
                canvas.translate(.0F, bmRect.height());
            }
            canvas.translate(bmRect.width(), -bmRect.height() * iterY);
        }
    }

    private static int iterations(int total, int start, int side) {
        final int diff = total - start;
        final int base = diff / side;
        return base + (diff % side > 0 ? 1 : 0);
    }

    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}