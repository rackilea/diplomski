case 'H': // hour in day (0-23)
case 'k': // hour in day (1-24) [but see note below]
{
    int hour = inDate.get(Calendar.HOUR_OF_DAY);
    // Historically on Android 'k' was interpreted as 'H', which wasn't
    // implemented, so pretty much all callers that want to format 24-hour
    // times are abusing 'k'. http://b/8359981.
    if (false && c == 'k' && hour == 0) {
        hour = 24;
    }
    replacement = zeroPad(hour, count);
}
break;