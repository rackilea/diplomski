@Override
public boolean onTouch(View v, MotionEvent event) {

if (event.getAction() == MotionEvent.ACTION_DOWN) {
    imageView.setPressed(true);
    textView.setPressed(true);
}
else if (event.getAction() == MotionEvent.ACTION_UP) {
    imageView.setPressed(false);
    textView.setPressed(false);
}
return false;
}