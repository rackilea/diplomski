import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnimatedView extends ImageView {
    private Context mContext;
    int x = -1;
    int y = -1;
    private int xVelocity = 0;
    private int yVelocity = 25;
    private int yAccel = 2;
    private Handler h;
    private final int FRAME_RATE = 20;

    public AnimatedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };



    protected void onDraw(Canvas c) {
        yVelocity += yAccel;

        BitmapDrawable ball = (BitmapDrawable) mContext.getResources()
                .getDrawable(R.drawable.cakes);
        if (x < 0 && y < 0) {
            x = this.getWidth() / 2;
            y = this.getHeight() / 2;
        } else {
            x += xVelocity;
            y += yVelocity;
            if ((x > this.getWidth() - ball.getBitmap().getWidth()) || (x < 0)) {
                xVelocity = xVelocity * -1;
                x = Math.min(this.getWidth() - ball.getBitmap().getWidth(), x);
                x = Math.max(0, x);
            }
            if ((y > this.getHeight() - ball.getBitmap().getHeight())
                    || (y < 0)) {
                yVelocity = (int)(yVelocity * -0.8f);

                y = Math.min(this.getHeight() - ball.getBitmap().getHeight(), y);
                y = Math.max(0, y);
            }
        }
        c.drawBitmap(ball.getBitmap(), x, y, null);

        h.postDelayed(r, FRAME_RATE);

    }
}