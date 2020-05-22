EncryptionKey(EncryptionKey encryptionkey)
    throws KrbCryptoException
{
    keyValue = (byte[])(byte[])encryptionkey.keyValue.clone();
    keyType = encryptionkey.keyType;
}