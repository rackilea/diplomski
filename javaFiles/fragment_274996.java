int chk_gender = rg_gender.getCheckedRadioButtonId();
            if (chk_gender != -1) {
                Gender = ((RadioButton)findViewById(chk_gender)).getText().toString();
            }
            else
            {
                Gender = "";
            }