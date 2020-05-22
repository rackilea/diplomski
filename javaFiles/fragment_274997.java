rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                Gender = ((RadioButton)findViewById(checkedId)).getText().toString();
            }
            else
            {
                Gender = "";
            }
        }
    });