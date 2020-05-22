e.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            Toast.makeText(MainActivity.this, e.getText(), Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
});