button.setOnTouchListener(new View.OnTouchListener() 
{

    public boolean onTouch(View v, MotionEvent event)
    {
        if (me.getAction() == MotionEvent.ACTION_MOVE )
        {
             LayoutParams params = new LayoutParams(v.getWidth(),  v.getHeight());
             params.setMargins((int)event.getRawX() - v.getWidth()/2, (int)(event.getRawY() - v.getHeight()), (int)event.getRawX() - v.getWidth()/2, (int)(event.getRawY() - v.getHeight()));
             v.setLayoutParams(params);
        }
        return false;
    }
});