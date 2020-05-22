public synchronized Object get(final Object key) {
    final Object value = super.get(key);
    final String valueStr = 
            (value instanceof String) ? (String)value : null;
    return decode(valueStr);
}


private synchronized String decode(final String encodedValue) {

    if (!PropertyValueEncryptionUtils.isEncryptedValue(encodedValue)) {
        return encodedValue;
    }
    if (this.stringEncryptor != null) {
        return PropertyValueEncryptionUtils.decrypt(encodedValue, this.stringEncryptor);

    }
    if (this.textEncryptor != null) {
        return PropertyValueEncryptionUtils.decrypt(encodedValue, this.textEncryptor);
    }

    /*
     * If neither a StringEncryptor nor a TextEncryptor can be retrieved
     * from the registry, this means that this EncryptableProperties
     * object has been serialized and then deserialized in a different
     * classloader and virtual machine, which is an unsupported behaviour. 
     */
    throw new EncryptionOperationNotPossibleException(
            "Neither a string encryptor nor a text encryptor exist " +
            "for this instance of EncryptableProperties. This is usually " +
            "caused by the instance having been serialized and then " +
            "de-serialized in a different classloader or virtual machine, " +
            "which is an unsupported behaviour (as encryptors cannot be " +
            "serialized themselves)");

}