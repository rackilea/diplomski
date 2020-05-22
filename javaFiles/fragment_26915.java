TextView.OnEditorActionListener mEditor = new TextView.OnEditorActionListener()
{
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        if (actionId == EditorInfo.IME_ACTION_DONE)
        {
            if (!TextUtils.isEmpty(v.getText().toString())){
                // you calculations method
            } else {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }

        return false;
    }
};