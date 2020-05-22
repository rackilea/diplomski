@Override
public void onClick(View v){

   int selectedId = radioG.getCheckedRadioButtonId();
   if(selectedId != -1) {    
        selectedRadioButton = (RadioButton)view.findViewById(selectedId);
   }

   boolean isInserted = myDB.insertData(editName.getText().toString() ,
   editFamilyname.getText().toString() ,
   editDob.getText().toString() ,
   ....
 }