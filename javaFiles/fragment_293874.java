LogicalTypes.register(EncryptedLogicalType.ENCRYPTED_LOGICAL_TYPE_NAME, new LogicalTypes.LogicalTypeFactory() {
    private final LogicalType encryptedLogicalType = new EncryptedLogicalType();
    @Override
    public LogicalType fromSchema(Schema schema) {
        return encryptedLogicalType;
    }
});