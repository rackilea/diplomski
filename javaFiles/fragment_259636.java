@Override
  public void onCheckedChanged(RadioGroup group, int checkedId) {
    RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
    int  CorrectAnswer=Integer.parseInt(checkedRadioButton.getTag().toString());
    ....your code here...
  }