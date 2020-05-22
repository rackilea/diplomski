public static boolean downloadstatus=true;
    mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                    "Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            your_AsyncTask.cancel(true);  //<<<<<
                             downloadstatus=false;
                            dialog.cancel();
                        }
                    });