DialogCaller.showDialog(getActivity()/getApplicationContext(),"Kingmeka dialog ",String.valueOf(beatsAvg) + "bpm",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();
                }
            });