int selectedId = radioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MyAndroidAppActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();