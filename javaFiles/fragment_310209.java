public void restart(View v) {
    quantity = 0;
    display(quantity);
    displayPrice(quantity);
    TextView view = (TextView) findViewById(R.id.enjoy);
    view.setPadding(0, 0, 0, 0);
    view.setText("");
}