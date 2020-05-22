final Calendar c = Calendar.getInstance();
mHour = c.get(Calendar.HOUR_OF_DAY);
mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
TimePickerDialog timePickerDialog = new TimePickerDialog(this,
              new TimePickerDialog.OnTimeSetListener() {
              @Override
              public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                    txtTime.setText(hourOfDay + ":" + minute);
                   }
              }, mHour, mMinute, false);
timePickerDialog.show();