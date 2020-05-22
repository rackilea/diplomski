public class notificationService extends Service{

private WindowManager windowManager;
WindowManager.LayoutParams params;
FloatingActionButton Abutton;
Context context;
public FloatingActionMenu menu;
private final IBinder noteBind = new NotificationBinder();

@Override
public boolean onUnbind(Intent intent){
    return false;
}
@Override
public IBinder onBind(Intent intent) {
    // TODO Auto-generated method stub
    return noteBind;
}

@Override
public void onCreate() {
    super.onCreate();

    windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

    Abutton = new FloatingActionButton(this);
    Abutton.setProgress(0,true);
    Abutton.setColorNormal(ResourcesCompat.getColor(getResources(),R.color.floatingButtonColor,null));
    Abutton.setColorPressed(ResourcesCompat.getColor(getResources(),R.color.floatingButtonColorPressed,null));
    Abutton.setColorRipple(ResourcesCompat.getColor(getResources(),R.color.floatingButtonColorRipple,null));


    Abutton.setImageResource(R.mipmap.pause_note);
    Abutton.setX(25);


    Abutton.setOnClickListener(new View.OnClickListener() {    //set onclick events here
        @Override
        public void onClick(View view) {

                // Handle your onClick event here.

        }
    });


    params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);

    params.gravity = Gravity.TOP | Gravity.LEFT;
    params.x = 0;
    params.y = 100;


    windowManager.addView(Abutton,params);  //directly add your floating button here.


    try {
        Abutton.setOnTouchListener(new View.OnTouchListener() {
            private WindowManager.LayoutParams paramsF = params;
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        // Get current time in nano seconds.

                        initialX = paramsF.x;
                        initialY = paramsF.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        paramsF.x = initialX + (int) (event.getRawX() - initialTouchX);
                        paramsF.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(Abutton, paramsF);
                        break;
                }
                return false;
            }
        });
    } catch (Exception e) {
        // TODO: handle exception
    }

}

@Override
public void onDestroy() {
    super.onDestroy();
    if (Abutton != null) windowManager.removeView(Abutton);
}
}