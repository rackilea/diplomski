class TimedTouchListener implements OnTouchListener{
    private final long millisRequired = 3000;
    private long downTime;

    @Override
    public boolean onTouch(View v, MotionEvent event){
        switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
            downTime = System.currentTimeMillis();
            return true;
            break;
        case MotionEvent.ACTION_UP:
            long upTime = System.currentTimeMillis();
            if( upTime - downTime > millisRequired ){
                doAction(); //doAction can be a method call, or any code you want to be executed.
                return true;
            }else{
                return true;
            }
        }
        return false;
    }
}