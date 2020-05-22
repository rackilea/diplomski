int selectedId = radioGroup.getCheckedRadioButtonId();

     RadioButton radioButton = (RadioButton) findViewById(selectedId);

     Toast.makeText(MyAndroidAppActivity.this,
                    radioButton.getText(), Toast.LENGTH_SHORT).show();