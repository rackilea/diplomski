addClass.setOnClickListener(new View.OnClickListener() {

    @Override 
    public void onClick(View v) {

        Button newButton = (Button) getLayoutInflater().inflate(R.layout.my_button, buttonsLayout, false);
        newButton.setText("New button");
        buttonsLayout.addView(newButton, buttonsLayout.getChildCount() - 1);

    } 
});