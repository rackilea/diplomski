listener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        TextView tv = (TextView) v;
        text = tv.getText().toString();
    }
};