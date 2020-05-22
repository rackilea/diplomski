btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TextView textView = (TextView)findViewById(R.id.textView7);

        Intent intent = getIntent();
        textView.setText(DataHolder.appleColor);
    }
});