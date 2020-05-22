// this doesn't belong here. get it in onClick of the positive Button
    final SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
    builder.setTitle("Disclaimer")
        .setMessage(this.getString(R.string.disclaimer))
        .setCancelable(false)
        .setIcon(R.drawable.caution)
        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            SharedPreferences.Editor edit = pref.edit(); // the same as with the pef object
            public void onClick (DialogInterface dialog, int id) { 

                boolean accepted = true; // no need for this because the if clause will always be true
                dialog.cancel(); // cancel the dialog IF the job here is done
                if(accepted == true)
                {
                edit.putString("Version", this.getString(R.string.version)); // delete the this pointer
                edit.commit();}
            }
            // no need for this method
            private String getString(int version) {
                // I had to create this method, cause i got an error the line above this.getstring(R.string.version)
                return null;
            }
        });
        .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.finish();
            }
        });