Button place = new Button(this);
LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) place.getLayoutParams();
params.weight = 1.0f;
place.setLayoutParams(params);


place.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        //handle the click
    }
});