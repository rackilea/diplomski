editText.setOnEditorActionListener(new OnEditorActionListener()
{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
        {
            if(actionId==EditorInfo.IME_ACTION_GO)
            {
                    //Handle go button pressed
            }
            return false;
        }
});