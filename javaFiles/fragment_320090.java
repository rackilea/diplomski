EditText a = (EditText)findViewById(R.id.a);
EditText c = (EditText)findViewById(R.id.c);

c.setOnEditorActionListener(new OnEditorActionListener() {        
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) 
    {
        // if the user pressed the "Next" button on the soft keyboard
        if(actionId==EditorInfo.IME_ACTION_NEXT)
        {
            a.requestFocus(); // change the focus to the 'a' EditText
        }
        return true; // keep the keyboard up
    }
});