public void AddData() {
    btnSave.setOnClickListener(
        new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int selectedId = radioG.getCheckedRadioButtonId();
                if(selectedId != -1) {
                    selectedRadioButton = (RadioButton)v.findViewById(selectedId);

                    boolean isInserted = myDB.insertData(editName.getText().toString() ,
                            editFamilyname.getText().toString() ,
                            editDob.getText().toString() ,
                            editAddress.getText().toString() ,
                            editPhonenb.getText().toString() ,
                            editEmail.getText().toString(),
                            selectedRadioButton.getText().toString()) ;
                    if(isInserted == true)
                        Toast.makeText(getActivity(), "Patient inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity(), "Patient not inserted", Toast.LENGTH_LONG).show();
                }

            }
        }
    );

}