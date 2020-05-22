Button stopButton = (Button) findViewById(R.id.StartTrackingEditStopTime_button);

SimpleDateFormat sdfStopTime = new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);

String newStoptime = sdfStopTime.format(
        new Date(System.currentTimeMillis() + 3600000));

stopButton.setText(newStopTime);