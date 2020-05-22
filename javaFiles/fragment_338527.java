Button btnCancel = userDataDialog.findViewById(R.id.btnCancel);
 btnCancel.setOnClickListener(new View.OnClickListener() {
 @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(key, "sampleText");
            editor.commit();
        }
 });