tvSets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // This is where the Dialog should be called and
                    // the user input from the Dialog should be returned
                    // 
                    // 


                    DialogFragment numberpicker = new CustomNumberPicker(new NoticeDialogListener() {

            @Override
            public void onDialogPositiveClick(DialogFragment dialog) {
                //What you want to do incase of positive click

            }

            @Override
            public void onDialogNegativeClick(DialogFragment dialog) {
               //What you want to do incase of negative click

            }
        };);
                    numberpicker.show(MainActivity.this.getSupportFragmentManager(), "NoticeDialogFragment");
                }

                // Here I would like to implement the interface of CustomNumberPicker
                // in order to get the user input entered in the Dialog
            });