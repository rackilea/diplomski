mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String yesOrNoStr = parent.getItemAtPosition(position).toString();
    boolean yesOrNo = yesOrNoStr.equals("YES");
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) { }
});