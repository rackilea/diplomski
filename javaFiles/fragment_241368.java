ProgressDialog progressDialog = new ProgressDialog(Add_ReminderActivity.this);
                progressDialog.setMessage("Please wait.");
                progressDialog.show();

                final View dialogView = View.inflate(Add_ReminderActivity.this, R.layout.time_picker_dialod, null);

                final AlertDialog alertDialog = new AlertDialog.Builder(Add_ReminderActivity.this).create();
                alertDialog.setView(dialogView);

                final TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

                if (Build.VERSION.SDK_INT >= 23) {
                    timePicker.setHour(00);
                    timePicker.setMinute(00);
                } else {
                    timePicker.setCurrentHour(00);
                    timePicker.setCurrentMinute(00);
                }

                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (Build.VERSION.SDK_INT >= 23) {
                            Selected_From_Time = Uri.encode(DigitPad(timePicker.getHour()) + ":" + DigitPad(timePicker.getMinute()) + ":" + "00");
                        } else {
                            Selected_From_Time = Uri.encode(DigitPad(timePicker.getCurrentHour()) + ":" + DigitPad(timePicker.getCurrentMinute()) + ":" + "00");
                        }

                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
                if (alertDialog.isShowing()) {
                    progressDialog.dismiss();
                }