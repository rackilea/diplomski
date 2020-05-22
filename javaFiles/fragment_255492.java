private AdapterView.OnItemSelectedListener listener;

 listener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1,
                                       int i, long arg3) {

                //startTimeString = adapterView.getItemAtPosition(i).toString();
                DateFormat currentDateFormat = new SimpleDateFormat("HH:mm:ss");
                userAvailableTimeInSF = currentDateFormat.format(new Date());

                final TextView startTimeSpinnerTV = (TextView) adapterView.getSelectedView();
                startTimeSpinnerTV.setText(userAvailableTimeInSF);

                switch (i) {
                    case 0:

                        // userAvailableTimeInSF = currentDateFormat.format(new Date());
                        startTimeSpinnerTV.setText("Now");
                        break;

                    case 1:

                        final Calendar c = Calendar.getInstance();
                        mHour = c.get(Calendar.HOUR_OF_DAY);
                        mMinute = c.get(Calendar.MINUTE);

                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {

                                        Calendar date = Calendar.getInstance();
                                        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                        date.set(Calendar.MINUTE, minute);
                                        date.set(Calendar.AM_PM, date.get(Calendar.AM_PM));

                                        //showTime(hourOfDay, minute);

                                       /* userAvailableTimeInSF = new SimpleDateFormat("HH:mm:ss").format(date.getTime());
                                        startTimeSpinnerTV.setText(userAvailableTimeAMPM);*/

                                        Toast.makeText(getBaseContext(), "userAvailableTimeInSF: " + userAvailableTimeInSF, Toast.LENGTH_SHORT).show();

                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        };
}