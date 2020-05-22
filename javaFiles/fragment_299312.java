changeBehaviorButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        yellowAdd2.setOnClickListener(aDifferentOnClickListener);
    }
});