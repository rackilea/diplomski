public class EncryptedConversion extends Conversion<ByteBuffer> {
    // Construct a unique instance for all the conversion. This have to be changed in case the conversion
    //   needs some runtime information (e.g.: an encryption key / a tenant_ID). If so, the get() method should 
    //   return the appropriate conversion per key.
    private static final EncryptedConversion INSTANCE = new EncryptedConversion();
    public static final EncryptedConversion get(){ return INSTANCE; }
    private EncryptedConversion(){ super(); }

    //This conversion operates on ByteBuffer and returns ByteBuffer
    @Override
    public Class<ByteBuffer> getConvertedType() { return ByteBuffer.class; }

    @Override
    public String getLogicalTypeName() { return EncryptedLogicalType.ENCRYPTED_LOGICAL_TYPE_NAME; }

    // fromBytes and toBytes have to be overridden as this conversion works on bytes. Other may need to be 
    //  overridden. The types supported need to be updated also in EncryptedLogicalType#validate(Schema schema)
    @Override
    public ByteBuffer fromBytes(ByteBuffer value, Schema schema, LogicalType type) {
        encryptedValue = __encryptionLogic__(value); 
        return encryptedValue;
    }

    @Override
    public ByteBuffer toBytes(ByteBuffer value, Schema schema, LogicalType type) {
        decryptedValue = __decryptionLogic__(value); 
        return decryptedValue;
    }
}