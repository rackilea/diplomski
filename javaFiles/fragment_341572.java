Button mConfirm2 = (Button)findViewById(R.id.bConfirm2);
        mConfirm2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mConfirm2.setEnabled(false);
                ParseUser currentUser = ParseUser.getCurrentUser();

               // Create the class and the columns
                currentUser.saveInBackground();


                currentUser.put("ActivityName", list_item_name); 

                currentUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        setProgressBarIndeterminateVisibility(false);

                        if (e == null) {
                            // Success!
                            Intent intent = new Intent(CasualEventsSingleItemActivity.this, usermatch.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(CasualEventsSingleItemActivity.this);
                            builder.setMessage(e.getMessage())
                                .setTitle(R.string.signup_error_title)
                                .setPositiveButton(android.R.string.ok, null);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                   }
               });
                //CasualEventsSingleItemActivity.this.startActivity(new Intent(CasualEventsSingleItemActivity.this, MatchingActivity.class));
            }
        });