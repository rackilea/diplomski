import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import R;

import StartingPoints;
import PointF;

public class OnSwipeTouchListener implements OnTouchListener {

    private static final String APP = OnSwipeTouchListener.class.getName() ;
    private final GestureDetector gestureDetector;
    PointF DownPT = null;
    PointF StartPT = null;

    Context _context;
    static  boolean isLeftMoved = false;
    static  boolean isRightMoved = false;

    /**
     * Max allowed duration for a "click", in milliseconds.
     */
    private static final int MAX_CLICK_DURATION = 1000;

    /**
     * Max allowed distance to move during a "click", in DP.
     */
    private static final int MAX_CLICK_DISTANCE = 15;
    private static final float PIXELS_PER_SECOND = 5;

    private long pressStartTime;
    private float pressedX;
    private float pressedY;
    private boolean stayedWithinClickDistance;
    Resources resources;
    private float startX = 0f;
    private float startY = 0f;
    private boolean isNewImage = true;




    public OnSwipeTouchListener(Context context, Resources resources) {
        this._context = context;
        gestureDetector = new GestureDetector(context, new GestureListener());
        DownPT = new PointF();
        StartPT = new PointF();
        this.resources = resources;

    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }

    public boolean onTouch(View v, MotionEvent e) {
        if(isNewImage){
            isNewImage = false;
            startX = v.getX();
            startY = v.getY();
        }
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //animation code
                DownPT.x = e.getX();
                DownPT.y = e.getY();
                StartPT = new PointF(v.getX(), v.getY());


                //calculation code
                pressStartTime = System.currentTimeMillis();
                pressedX = e.getX();
                pressedY = e.getY();
                stayedWithinClickDistance = true;
                break;

            case MotionEvent.ACTION_MOVE:
                // animation code
                PointF mv = new PointF(e.getX() - DownPT.x, e.getY() - DownPT.y);
                v.setX((int) (StartPT.x + mv.x));
                v.setY(startY);

                StartPT = new PointF(v.getX(), v.getY());
                if(mv.x < 0 ){
                    isLeftMoved = true;
                }
                if(mv.x > 0 ){
                    isRightMoved = true;
                }

                //calculation code
                if (stayedWithinClickDistance && distance(pressedX, pressedY, e.getX(), e.getY()) > MAX_CLICK_DISTANCE) {
                    stayedWithinClickDistance = false;
                }

                Log.d("Moved ","Item moved");
                break;
            case MotionEvent.ACTION_UP:
                if(!stayedWithinClickDistance){
                    v.setX(startX);
                    v.setY(startY);
                    isNewImage = true;
                }


                long pressDuration = System.currentTimeMillis() - pressStartTime;
                if (pressDuration < MAX_CLICK_DURATION && stayedWithinClickDistance) {
                    // Click event has occurred
                    Log.d("Stayed"," With Click event");
                    zoomAnimation(v);
                    isNewImage = true;
                }


                break;
            default:
                // Move image back to its original position, by default
                Log.d("default", "This is default ");
                v.setX(startX);
                v.setY(startY);
                isNewImage = true;
                break;

        }

        return gestureDetector.onTouchEvent(e);
    }


    private  float distance(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        float distanceInPx = (float) Math.sqrt(dx * dx + dy * dy);
        return pxToDp(distanceInPx);
    }

    private  float pxToDp(float px) {
        return px / resources.getDisplayMetrics().density;
    }

    private void zoomAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(_context, R.anim.zoom);
        view.startAnimation(animation);
    }





    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 20;
        private static final int SWIPE_VELOCITY_THRESHOLD = 50;



        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            float maxFlingVelocity    = ViewConfiguration.get(_context).getScaledMaximumFlingVelocity();
            float velocityPercentX    = velocityX / maxFlingVelocity;          // the percent is a value in the range of (0, 1]
            float normalizedVelocityX = velocityPercentX * PIXELS_PER_SECOND;  // where PIXELS_PER_SECOND is a device-independent measurement

            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();

            if (isLeftMoved || isRightMoved) {
                if(isRightMoved) {
                    isLeftMoved = false;
                    isRightMoved = false;
                    onSwipeRight();
                }
                else {
                    isLeftMoved = false;
                    isRightMoved = false;
                    onSwipeLeft();
                }
            }

            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return true;
        }
    }
}