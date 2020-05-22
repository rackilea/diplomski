public static int toInt32(double d) {
    int id = (int)d;
    if (id == d) {
        // This covers -0.0 as well
        return id;
    }

    if (d != d
        || d == Double.POSITIVE_INFINITY
        || d == Double.NEGATIVE_INFINITY)
    {
        return 0;
    }

    d = (d >= 0) ? Math.floor(d) : Math.ceil(d);

    double two32 = 4294967296.0;
    d = Math.IEEEremainder(d, two32);
    // (double)(long)d == d should hold here

    long l = (long)d;
    // returning (int)d does not work as d can be outside int range
    // but the result must always be 32 lower bits of l
    return (int)l;
}