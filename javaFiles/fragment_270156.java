ImageView imageView= (ImageView) view.findViewById(R.id.CounterImage);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter++;
        fab_text.setText(String.valueOf(counter));
    }
});