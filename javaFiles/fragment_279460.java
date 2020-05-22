@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    showValue.setText(savedInstanceState.getString("my_text"));
    counter=Integer.parseInt(savedInstanceState.getString("my_text"));
}