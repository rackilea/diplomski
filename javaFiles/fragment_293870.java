public class EncryptedLogicalType extends LogicalType {
    //The key to use as a reference to the type
    public static final String ENCRYPTED_LOGICAL_TYPE_NAME = "encrypted";

    EncryptedLogicalType() {
        super(ENCRYPTED_LOGICAL_TYPE_NAME);
    }

    @Override
    public void validate(Schema schema) {
        super.validate(schema);
        if (schema.getType() != Schema.Type.BYTES) {
            throw new IllegalArgumentException(
                    "Logical type 'encrypted' must be backed by bytes");
        }
    }
}