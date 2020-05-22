@Override
public void onClick(View v){

  int selectedId = radioG.getCheckedRadioButtonId();
  if(selectedId == radio1.getId()) {    
      selectedRadioButton = radio1;
  }
  else if(selectedId == radio2.getId()) {    
      selectedRadioButton = radio2;
  }