yourRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        public void onCheckedChanged(RadioGroup group, int val) {

            if(firstButton.isChecked())
                yourStringValue = firstButton.getText().toString();
            else if(secondButton.isChecked())
                yourStringValue = secondButton.getText().toString();
            else
                yourStringValue = thirdButton.getText().toString();
        }
        });