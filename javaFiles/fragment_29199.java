editText.setOnEditorActionListener(new OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            myArrayList.add(0, myEditText.getText().toString());

            myArrayAdapter.notifyDataSetChanged();
            myEditText.setText("");
            handled = true;
        }
        return handled;
    }
});