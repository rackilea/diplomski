public class SwipeRecogniser implements OnTouchListener {

    private OnSwipeListener onSwipeListener;
    private float XWherePressed;
    private float XWhereReleased;
    private float YWherePressed;
    private float YWhereReleased;
    private static final int MINIMUM_DISTANCE_FOR_SWIPE = 100;


    public SwipeRecogniser(OnSwipeListener onSwipeListener)
    {
        this.onSwipeListener = onSwipeListener;
    }

    public boolean onTouch(View v, MotionEvent event)
    {
        switch(event.getAction())
        {

        case MotionEvent.ACTION_DOWN:
            this.XWherePressed = event.getX();
            this.YWherePressed = event.getY();

            break;

        case MotionEvent.ACTION_UP:
            this.XWhereReleased = event.getX();
            this.YWhereReleased = event.getY();

            float deltaX = XWhereReleased - XWherePressed;
            float deltaY = YWhereReleased - YWherePressed;

            if (Math.abs( deltaX ) > this.MINIMUM_DISTANCE_FOR_SWIPE)
            {
                //HORIZONTAL SWIPE
                if(deltaX > 0 )
                {
                    onSwipeListener.onRightwardsSwipe();
                    return true;
                }

                if(deltaX < 0)
                {
                    onSwipeListener.onLeftwardsSwipe();
                    return true;
                }

            }
            else return true;

            if (Math.abs( deltaY) > this.MINIMUM_DISTANCE_FOR_SWIPE)
            {
                //VERTICAL SWIPE
                if( deltaY < 0 )
                {
                    onSwipeListener.onDownwardsSwipe();
                    return true;
                }

                if ( deltaY > 0 )
                {
                    onSwipeListener.onUpwardsSwipe();
                    return true;
                }

            }
            else return true;

            break;  
        }   
        return true;
    }
}