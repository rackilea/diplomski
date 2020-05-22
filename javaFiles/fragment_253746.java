final   DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        final   TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        btnSet.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String strDateTime = dp.getYear() + "-" + (dp.getMonth() + 1) + "-" + dp.getDayOfMonth() + " "+ tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                Toast.makeText(TimeDate.this, "User selected " + strDateTime + "Time", Toast.LENGTH_LONG).show(); //Generate a toast only if you want 
                finish();   // If you want to continue on that TimeDateActivity
                 // If you want to go to new activity that code you can also write here
            }});