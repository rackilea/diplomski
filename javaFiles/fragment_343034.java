public class myView extends View {
    Paint paint = new Paint();
    public myView(Context context) {
        super(context);
        paint.setColor(Color.YELLOW);
        movePlayer0Runnable.run(); //this is the initial call to draw player at index 0
    }

    @Override
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);  //IMPORTANT to draw the background
        arr[0].draw(canvas, paint);
    }

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable movePlayer0Runnable = new Runnable(){
        public void run(){
            arr[0].update(true, true);
            invalidate(); //will trigger the onDraw
            handler.postDelayed(this,5000); //in 5 sec player0 will move again
        }
    }   
    ... 
}