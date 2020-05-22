@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    myIntVariable = savedIntanceState.getInt(KEY_INDEX, 0);
}