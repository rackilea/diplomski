public String toString()
{
    final byte MIN_2DIGITS = 10;
    String str = "";
    // my input
    if (hours < MIN_2DIGITS) {
        str += "0" + hours + ":";
    } else
        str += hours + ":";
    if (minutes < MIN_2DIGITS) {
        str += "0" + minutes + ":";
    } else
        str += minutes + ":";
    if (seconds < MIN_2DIGITS) {
        str += "0" + seconds;
    } else
        str += seconds;
    // end of my input
    return str;
}