public class MyOnKeyboardActionListener implements OnKeyboardActionListener {
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        // handle key code
    }

    @Override
    public void onText(CharSequence text) {
        Log.d("DEBUG", "input text: " + text);
    }

    @Override public void onPress(int primaryCode) { }
    @Override public void onRelease(int primaryCode) { }
    @Override public void swipeLeft() { }
    @Override public void swipeRight() { }
    @Override public void swipeDown() { }
    @Override public void swipeUp() { }
}