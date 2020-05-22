public class EncryptedData extends Data {
    // any attribute is inherited from data
    // this class does not expose new attributes

    /**
     * Copy constructor.
     */
    EncryptedData(Data data) {
        super();
        this.attribA = data.attribA;
        ...
    };

    public static EncryptedData valueOf(String opaque) {
        // here, you transform the encrypted String into
        // a regular String, then you call Data.valueOf ...
        // example:
        String decrypted = decrypt(opaque);
        return new EncryptedData( Data.valueOf(decrypted) );
    }
}