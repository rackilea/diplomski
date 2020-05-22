private void displayUserSettings() {
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.websmithing.gpstracker.prefs", Context.MODE_PRIVATE);
            intervalInMinutes = sharedPreferences.getInt("intervalInMinutes", 1);

            switch (intervalInMinutes) {
                case 1:
                    intervalRadioGroup.check(R.id.i1);
                    break;
                case 5:
                    intervalRadioGroup.check(R.id.i5);
                    break;
                case 15:
                    intervalRadioGroup.check(R.id.i15);
                    break;
            }

                txtWebsite.setText(sharedPreferences.getString("defaultUploadWebsite", defaultUploadWebsite));

        //this line for modify and sharepreferences
                spinner.setSelection(sharedPreferences.getInt("position",0));


}