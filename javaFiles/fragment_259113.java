@Override
public void onCreate(Bundle savedInstanceState) {
  //your code

  addListenerOnSpinnerItemSelection();

  //more of your code
}

public void addListenerOnSpinnerItemSelection() {
  spMulti = (Spinner) findViewById(R.id.spMulti);
  spMulti.setOnItemSelectedListener(new CustomOnItemSelectedListener());
}