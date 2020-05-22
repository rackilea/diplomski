/**
 * Time unit representing one thousandth of a microsecond
 */
NANOSECONDS {
    public long toNanos(long d)   { return d; }
    public long toMicros(long d)  { return d/(C1/C0); }
    public long toMillis(long d)  { return d/(C2/C0); }
    public long toSeconds(long d) { return d/(C3/C0); }
    public long toMinutes(long d) { return d/(C4/C0); }
    public long toHours(long d)   { return d/(C5/C0); }
    public long toDays(long d)    { return d/(C6/C0); }
    public long convert(long d, TimeUnit u) { return u.toNanos(d); }
    int excessNanos(long d, long m) { return (int)(d - (m*C2)); }
},

/**
 * Time unit representing one thousandth of a millisecond
 */
MICROSECONDS {
    public long toNanos(long d)   { return x(d, C1/C0, MAX/(C1/C0)); }
    public long toMicros(long d)  { return d; }
    public long toMillis(long d)  { return d/(C2/C1); }
    public long toSeconds(long d) { return d/(C3/C1); }
    public long toMinutes(long d) { return d/(C4/C1); }
    public long toHours(long d)   { return d/(C5/C1); }
    public long toDays(long d)    { return d/(C6/C1); }
    public long convert(long d, TimeUnit u) { return u.toMicros(d); }
    int excessNanos(long d, long m) { return (int)((d*C1) - (m*C2)); }
},