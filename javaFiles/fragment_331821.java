public static Date fromDoubleToDateTime(double OADate) 
{
    long num = (long) ((OADate * 86400000.0) + ((OADate >= 0.0) ? 0.5 : -0.5));
    if (num < 0L) {
        num -= (num % 0x5265c00L) * 2L;
    }
    num += 0x3680b5e1fc00L;
    num -=  62135596800000L;

    return new Date(num);
}