@Override
public Conversion<?> getConversion(int fieldIndex) {
    // This allow us to have a more flexible conversion retrieval, so we don't have to code it per field.
    Schema fieldSchema = SCHEMA$.getFields().get(fieldIndex).schema();
    if ((fieldSchema.getLogicalType() != null)
            && (fieldSchema.getLogicalType().getName() == EncryptedLogicalType.ENCRYPTED_LOGICAL_TYPE_NAME)){
     // here we could pass to the get() method a runtime information, e.g.: a tenantId that can be found in the data structure.
        return EncryptedConversion.get();
    }
    return null;
}