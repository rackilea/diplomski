TimePickerFragment timePickerFragment = new TimePickerFragment();
            timePickerFragment.setOnTimeSetListener(new OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar datetime = Calendar.getInstance();
                    Calendar c = Calendar.getInstance();
                    datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    datetime.set(Calendar.MINUTE, minute);
                    if (datetime.getTimeInMillis() >= c.getTimeInMillis()) {
                        //it's after current
                         int hour = hourOfDay % 12;
                    btnPickStartTime.setText(String.format("%02d:%02d %s", hour == 0 ? 12 : hour,
                            minute, hourOfDay < 12 ? "am" : "pm"));
                    } else {
                        //it's before current'
                        Toast.makeText(getApplicationContext(), "Invalid Time", Toast.LENGTH_LONG).show();
                    }
                }
            });
            timePickerFragment.show(getSupportFragmentManager(), "TIME");