AlertDialog.Builder StopDialog = new AlertDialog.Builder(TestActivity.this);
        StopDialog.setTitle("Title");
        StopDialog.setMessage("Stop");
        StopDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                ((Protoype2) getApplication()).setRequestingLocationUpdates(false);
                dialog.dismiss();
            }
        });
        StopDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((Protoype2) getApplication()).setRequestingLocationUpdates(true);
            }
        });
        StopDialog.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Closes box
                dialog.dismiss();
            }
        });
        AlertDialog alert = StopDialog.create();
        alert.show();