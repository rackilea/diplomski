crg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int radioButtonID = group.getCheckedRadioButtonId();
            View radioButton = group.findViewById(radioButtonID);
            //find radiobutton position
            int position = group.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) crg.getChildAt(position);
            String selection = (String) btn.getText();
        }
    });