public class MainActivity extends Activity {
       float x1 = 0;
       float y1 = 0;
       float x2 ;
       float y2 ;
    ...

    @Override
    public boolean onTouchEvent(MotionEvent event){
    int action = MotionEventCompat.getActionMasked(event);

            switch(action) {
                case (MotionEvent.ACTION_DOWN) :
                    x1 = event.getX();
                    y1 = event.getY();
                    return true;
                case (MotionEvent.ACTION_UP) :
                    x2 = event.getX();
                    y2 = event.getY();

                    //if left to right sweep event on screen
                    if (x1 < x2)
                    {
                        Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
                    }

                    // if right to left sweep event on screen
                    if (x1 > x2)
                    {
                        Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
                    }

                    // if UP to Down sweep event on screen
                    if (y1 < y2)
                    {
                        Toast.makeText(this, "UP to Down Swap Performed", Toast.LENGTH_LONG).show();
                    }

                    //if Down to UP sweep event on screen
                    if (y1 > y2)
                    {
                        Toast.makeText(this, "Down to UP Swap Performed", Toast.LENGTH_LONG).show();
                    }
                    return true;