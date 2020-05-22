// a Map for holding the sequencing
private ConcurrentMap<String, AtomicInteger> _sequence = 
        new ConcurrentHashMap<>();

/**
 * Returns a unique, incrementing sequence, formatted to
 * 0 prefixed, 3 places, based upon the User's initials
 * and the registration year
 */
public String getSequence(String initials, String year)
{
    String key = makePrefix(initials, year);
    AtomicInteger chk = new AtomicInteger(0);
    AtomicInteger ai = _sequence.putIfAbsent(key, chk);
    if (ai == null) {
        ai = chk;
    }

    int val = ai.incrementAndGet();

    String fmt = String.format("%03d", val);

    return fmt;
}

/**
 * A helper method to make the prefix, which is the
 * concatintion of the initials, a "-", and a year.
 */
private String makePrefix (String initials, String year)
{
    return initials + "-" + year;
}