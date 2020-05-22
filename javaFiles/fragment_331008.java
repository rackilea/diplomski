public interface ProtocolStack {

    String getName();

    Protocol getRootProtocol();

    Dissection dissect(DataInput input, Dissection dissection, DissectOptions options);
}