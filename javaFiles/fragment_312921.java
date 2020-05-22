myEditText.setOnEditorActionListener(new OnEditorActionListener() {
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE) {
            submitButton.performClick();
            return true;
        }

        return false;
    }
});