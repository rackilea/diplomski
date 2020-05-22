CustomKeyboardView kbView = (CustomKeyboardView) findViewById(R.id.keyboard_view);
kbView.setKeyboard(new Keyboard(this, R.xml.myCustomKeyboard);
kbView.setOnKeyboardActionListener(new OnKeyboardActionListener() {
    @Override
    public void onPress(int primaryCode) {
        // A Key was pressed
    }
    ....
}