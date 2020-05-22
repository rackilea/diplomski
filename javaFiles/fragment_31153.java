List<CheckBox> checkBoxes= new ArrayList<CheckBox>();
checkBoxes.add(checkBox1);

//keep adding all your checkboxes to this list
String checkBoxText = "";

for (CheckBox checkBox: checkBoxes){
   if(checkBox.isChecked()){ 
      checkBoxText= checkBoxText + "-" +checkBox.getText().toString();
      //Do what you like with this
   }
}