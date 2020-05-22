public static String CreateSessionId()
{
    /*<DiameterIdentity>;<high 32 bits>;<low 32 bits>[;<optional value>]
      <high 32 bits> and <low 32 bits> are decimal representations of the
       high and low 32 bits of a monotonically increasing 64-bit value.  The
       64-bit value is rendered in two part to simplify formatting by 32-bit
       processors.  At startup, the high 32 bits of the 64-bit value MAY be
       initialized to the time, and the low 32 bits MAY be initialized to
       zero.  This will for practical purposes eliminate the possibility of
       overlapping Session-Ids after a reboot, assuming the reboot process
       takes longer than a second.  Alternatively, an implementation MAY
       keep track of the increasing value in non-volatile memory.

     * <optional value> is implementation specific but may include a modem's
       device Id, a layer 2 address, timestamp, etc.
       Example, in which there is no optional value:
          accesspoint7.acme.com;1876543210;523
       Example, in which there is an optional value:
          accesspoint7.acme.com;1876543210;523;mobile@200.1.1.88*/

    String SessionID = "";

    String hostIdentity;


    int low32 = Sequence.getNext();

    int high32 = 0;

    long id = ((long)low32) << 32 | high32;

    String optional = String.valueOf(Sequence.getNext());

    SessionID = hostIdentity + ";" + id + ";" + optional;

    return SessionID;
}

public final class Sequence
{
    private static int _value = -1;
    private static final Object m_lock = new Object();

    public static int getNext()
    {
        synchronized (m_lock)
        {
            if (_value == Integer.MAX_VALUE)
            {
                _value = -1;
            }
            return ++_value;
        }
    }
}