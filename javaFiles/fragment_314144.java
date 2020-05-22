public class MainActivity extends AppCompatActivity {

private final String TAG = MainActivity.class.getSimpleName();
private Button b_draw_all;
private Button b_draw_color;
private Button b_draw_bitmap;
private Button b_draw_text;
private Button b_clear;
private SurfaceView sv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    b_clear = (Button) findViewById(R.id.b_clear);
    b_clear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                clearCanvas(canvas);
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });

    b_draw_color = (Button) findViewById(R.id.b_draw_color);
    b_draw_color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                clearCanvas(canvas);
                drawColor(canvas, Color.MAGENTA);
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });

    b_draw_bitmap = (Button) findViewById(R.id.b_draw_bitmap);
    b_draw_bitmap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                clearCanvas(canvas);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
                drawBitmap(canvas, bitmap);
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });

    b_draw_text = (Button) findViewById(R.id.b_draw_text);
    b_draw_text.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                clearCanvas(canvas);
                drawText(canvas, "Android");
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });

    b_draw_all = (Button) findViewById(R.id.b_draw_all);
    b_draw_all.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                //order is important
                //draw color, bitmap and then text
                drawColor(canvas, Color.MAGENTA);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
                drawBitmap(canvas, bitmap);
                drawText(canvas, "Android");
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });

    sv = (SurfaceView) findViewById(R.id.sv);
    sv.post(new Runnable() {
        @Override
        public void run() {
            if (sv.getHolder().getSurface().isValid()) {
                Canvas canvas = sv.getHolder().lockCanvas();
                clearCanvas(canvas);
                sv.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    });
}


private int[] getSurfaceDimensions(){
    return new int[]{sv.getWidth(), sv.getHeight()};
}

/**
 *
 * @param canvas
 * @param color color
 */
private void drawColor(Canvas canvas, int color){
    canvas.drawColor(color, PorterDuff.Mode.SRC);
}

private void drawBitmap(Canvas canvas, Bitmap bitmap){
    int[] surfaceDimensions = getSurfaceDimensions();
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.CYAN);
    paint.setStyle(Paint.Style.FILL);
    paint.setTextSize(100);
    paint.setTextAlign(Paint.Align.CENTER);
    Rect rectE = new Rect(surfaceDimensions[0] / 4, surfaceDimensions[1] / 4,
            3 * surfaceDimensions[0] / 4, 3 * surfaceDimensions[1] / 4);
    canvas.drawBitmap(bitmap, null, rectE, paint);
}

private void drawText(Canvas canvas, String text){
    int[] surfaceDimensions = getSurfaceDimensions();
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.CYAN);
    paint.setStyle(Paint.Style.FILL);
    paint.setTextSize(100);
    paint.setTextAlign(Paint.Align.CENTER);
    canvas.drawText(text, surfaceDimensions[0]/ 2f,
            surfaceDimensions[1] / 2f, paint);
}

private void clearCanvas(Canvas canvas) {
    drawColor(canvas, Color.WHITE);
}

}