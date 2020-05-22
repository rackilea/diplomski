final Button button = (Button) findViewById(R.id.button_id);
button.setOnTouchListener(new View.OnTouchListener()
{
    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            // Do something
        }
    }
});