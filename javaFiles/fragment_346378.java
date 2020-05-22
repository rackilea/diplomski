@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {

    if(keyCode == KeyEvent.KEYCODE_BACK) {
        // your implementation here
        // finish(); - to exit the Activity
        return true; // shows you consumed the event with your implementation
    }
    return super.onKeyDown(keyCode, event);
}