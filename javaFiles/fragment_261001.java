public interface MyMarker extends Marker {
    // a list of destination addresses, like "a@c.com, x@y.net"
    String getSmtpTo();
    // an "id" to tell the buffers apart, could be "smtpTo" itself
    // but in my case it would mix different reports that goes to the same addresses
    String getDiscriminatingValue();
}