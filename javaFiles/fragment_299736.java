mDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getResources().getString(R.string.dialognothanks),
            new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                mDialog.cancel();
                                        finish();
                                }
                        });