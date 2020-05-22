/**
 * Verifies current frame belongs to RTP protocol.
 *
 * @param input data input
 * @param dissection initial dissection
 * @return true if protocol frame is RTP
 */
@Override
public final boolean isProtocol(final DataInput input, final Dissection dissection) {
    int available = input.available();
    byte octet    = input.getByte();
    byte version  = getVersion(octet);
    byte octet2   = input.getByte(1);
    byte pt       = (byte) (octet2 & 0x7F);

    return ((pt < 0x47) & (RTP_VERSION == version));
}