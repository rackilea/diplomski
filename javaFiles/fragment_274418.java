public static final Payload INSTANCE = new Payload();
// Add this line to Payload
public static final Payload EMPTY = new Payload();
...
// Use EMPTY payload when the caller does not supply an actual one:
this.data = payload != null ? payload.getMap() : Payload.EMPTY.getMap();