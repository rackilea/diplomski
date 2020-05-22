builder.setTitle("Disclaimer")
        .setMessage(this.getString(R.string.disclaimer))
        .setCancelable(false)
        .setIcon(R.drawable.caution)
        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {

            public void onClick (DialogInterface dialog, int id) { 
                SharedPreferences pref = getSharedPreferences("Preferences", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Version", getString(R.string.version));
                edit.commit();
                dialog.cancel();
            }

        });
        .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.finish();
            }
        });