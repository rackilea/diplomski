public class CommPortIdentifier ... {

...

    public CommPort open(java.lang.String appname, int timeout)
            throws PortInUseException {

        CommPort val = new NonAbstractCommPort( ... );

        // Do something here

        return val;
    }

...

}