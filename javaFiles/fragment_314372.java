view.setOnTouchListener(new OnTouchListener() {

@Override
public boolean onTouch(View v, MotionEvent event) {
if (event.getAction() == MotionEvent.ACTION_UP) {
    view.setBackgroundColor(Color.rgb(1, 1, 1));
    Log.d("onTouch", "MotionEvent.ACTION_UP" );
}
if (event.getAction() == MotionEvent.ACTION_DOWN) {
    view.setBackgroundColor(Color.rgb(23, 128, 0));
    Log.d("onTouch", "MotionEvent.ACTION_DOWN" );
    return true;
}

if (event.getAction() == MotionEvent.ACTION_CANCEL) {
    view.setBackgroundColor(Color.rgb(1, 1, 1));
    Log.d("onTouch", "MotionEvent.ACTION_CANCEL" );
}
return false;
}
});