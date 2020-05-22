Calendar cal = Calendar.getInstance();

    int hrs = cal.get(Calendar.HOUR_OF_DAY);

    Calendar alCal = Calendar.getInstance();
    alCal.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());

    alCal.set(Calendar.MINUTE, timePicker.getCurrentMinute());

    if(timePicker.getCurrentHour() < hrs){
        alCal.add(Calendar.DAY_OF_MONTH, 1);
    }

    long diff = alCal.getTimeInMillis() - cal.getTimeInMillis();

    long leftHrs = (diff / (60 * 60 * 1000));
    long leftMin = (diff / (60 * 1000)) - (leftHrs * 60);

    // Output
    Toast.makeText(this,"Hours: "+leftHrs+"Minutes: "+leftMin,Toast.LENGTH_SHORT).show();