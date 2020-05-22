public static Timestamp diff (java.util.Date t1, java.util.Date t2)
{
    // Make sure the result is always > 0
    if (t1.compareTo (t2) < 0)
    {
        java.util.Date tmp = t1;
        t1 = t2;
        t2 = tmp;
    }

    // Timestamps mix milli and nanoseconds in the API, so we have to separate the two
    long diffSeconds = (t1.getTime () / 1000) - (t2.getTime () / 1000);
    // For normals dates, we have millisecond precision
    int nano1 = ((int) t1.getTime () % 1000) * 1000000;
    // If the parameter is a Timestamp, we have additional precision in nanoseconds
    if (t1 instanceof Timestamp)
        nano1 = ((Timestamp)t1).getNanos ();
    int nano2 = ((int) t2.getTime () % 1000) * 1000000;
    if (t2 instanceof Timestamp)
        nano2 = ((Timestamp)t2).getNanos ();

    int diffNanos = nano1 - nano2;
    if (diffNanos < 0)
    {
        // Borrow one second
        diffSeconds --;
        diffNanos += 1000000000;
    }

    // mix nanos and millis again
    Timestamp result = new Timestamp ((diffSeconds * 1000) + (diffNanos / 1000000));
    // setNanos() with a value of in the millisecond range doesn't affect the value of the time field
    // while milliseconds in the time field will modify nanos! Damn, this API is a *mess*
    result.setNanos (diffNanos);
    return result;
}