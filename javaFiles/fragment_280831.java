value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            if (value.getText().toString().trim().length() < 3)
                value.setError("Failed");
            else
                value.setError(null);
        }
    }
});