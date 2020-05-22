theButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(spinner1.getSelectedItemPosition() == spinner2.getSelectedItemPosition()){
            errorTextView.setError("Error");
        }