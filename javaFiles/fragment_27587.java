private boolean saveUserSettings() {
        if (textFieldsAreEmptyOrHaveSpaces()) {
            return false;
        }

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.websmithing.gpstracker.prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch (intervalRadioGroup.getCheckedRadioButtonId()) {
            case R.id.i1:
                editor.putInt("intervalInMinutes", 1);
                break;
            case R.id.i5:
                editor.putInt("intervalInMinutes", 5);
                break;
            case R.id.i15:
                editor.putInt("intervalInMinutes", 15);
                break;
        }

        //editor.putString("userName", txtUserName.getText().toString().trim());
        editor.putString("userName", spnrEmployee.getSelectedItem().toString().trim());
        editor.putString("defaultUploadWebsite", txtWebsite.getText().toString().trim());
        editor.putInt("position", spnrEmployee.getSelectedItemPosition());
        editor.apply();

        return true;
    }