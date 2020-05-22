public boolean isWithinHour(Calendar given)
{
    long oldTime = given.getTimeInMillis();
    long newTime = Calendar.getInstance().getTimeInMillis();

    long diff = newTime - oldTime;
    return (diff <= 3600 * 1000);    // 3600 seconds in millis
}