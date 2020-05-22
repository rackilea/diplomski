private final Handler handler = new Handler();
final Runnable showDialogRunnable = new Runnable() {
            @Override
            public void run() {
                builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You are about to set the Nearby friends radius on " + rangeBarValue + "km") ;
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        privateAccountsSwitch.setChecked(true);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        privateAccountsSwitch.setChecked(false);
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.alertDialogPositiveButton));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.alertDialogNegativeButton));
            }
        };