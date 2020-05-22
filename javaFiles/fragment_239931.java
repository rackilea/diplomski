callButton.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
            OnClickListener listener = new OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(which == Dialog.BUTTON_POSITIVE)
                    {
                        try {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+phoneNumber));
                            startActivity(callIntent);
                        } catch (ActivityNotFoundException activityException) {
                            Log.e("Calling a Phone Number", "Call failed", activityException);
                        }
                    }
                }           
            };

            new AlertDialog.Builder(v.getContext())
            .setMessage("Are you sure you want to leave the application?")
            .setPositiveButton("Yes", listener)
            .setNegativeButton("No", listener)
            .show();
        }
    }