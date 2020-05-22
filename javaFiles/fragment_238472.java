SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
Date date = null;
try {
    date = simpleDateFormat.parse(yearNow + ":" + monthNow + ":" + dayNow + ":" + hourNow + ":" + minuteNow);
} catch (ParseException e) {
    e.printStackTrace();