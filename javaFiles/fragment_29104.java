@Override
  public void onCheckedChanged(RadioGroup group, int checkedId) {
      RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
      if(checkedRadioButton!=null)
      if(checkedRadioButton.getTag() !=null){
        int  CorrectAnswer = Integer.parseInt(
                         checkedRadioButton.getTag().toString());
          ....your code here

       } 
    }