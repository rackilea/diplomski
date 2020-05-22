/**
 * High-level dissector contract definition. Dissector is meant to be a simple
 * protocol decoder, which analyzes protocol binary image and produces number
 * of fields.
 *
 * @author Renat.Gilmanov
 */
public interface Dissector {

    /**
     * Returns dissector type.
     */
    DissectorType getType();

    /**
     * Verifies packet data belongs to the protocol represented by this dissector.
     */
    boolean isProtocol(DataInput input, Dissection dissection);

    /**
     * Performs the dissection.
     */
    Dissection dissect(DataInput input, Dissection dissection);

    /**
     * Returns a protocol which corresponds to the current dissector.
     *
     * @return a protocol instance
     */
    Protocol getProtocol();
}