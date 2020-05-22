edittext.setOnEditorActionListener(new OnEditorActionListener() { 
public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_GO) {
        Log.i(TAG,"Here you can perform actions");   //like btn.performClick();
        return true;
    }    
    return false;
}
});