calc_monday.setOnLongClickListener(
        new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {

                SettingDialogClass SDC = new SettingDialogClass(MainActivity.this);

                EditText texii = (EditText) SDC.findViewById(R.id.set_Subject_ID);

                Button btnSave = (Button)SDC.findViewById(R.id.your_custom_button);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(subjectKey, texii.getText().toString());
                        editor.apply();
                        SDC.dismiss();
                    }
                });

                SDC.show();

                return true;
            }
        }
);