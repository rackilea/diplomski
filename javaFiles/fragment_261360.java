long dbMillis = ... // get date value from DB, in UTC already

Calendar cal = Calendar.getInstance(); // get device's date time with
                                       // default device time zone
long now = cal.getTimeInMillis(); // returns device's date time in UTC

long diff = Math.abs(now - dbMillis);