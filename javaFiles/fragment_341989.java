new AlertDialog.Builder(this)
        .setMessage("Are you sure?")
        .setPositiveButton("Yes", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestAndroidActivity.this, "YES CLICKED",
                        Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("No", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestAndroidActivity.this, "NO CLICKED",
                        Toast.LENGTH_LONG).show();
            }
        }).show();