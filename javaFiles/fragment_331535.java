private EncryptedContentInfo parseContentInfo(final byte[] encrypted) throws CryptoException {
        try {
            // create a new byte array stream
            ByteArrayInputStream bin = new ByteArrayInputStream(encrypted);
            // create an ASN.1 input stream
            ASN1InputStream ain = new ASN1InputStream(bin);

            // read the whole sequence
            ASN1Sequence mainSequence = (ASN1Sequence) ain.readObject();
            // check if it is an encrypted data
            DERObjectIdentifier mainIdentifier = (DERObjectIdentifier) mainSequence
                    .getObjectAt(ASN1IDENTIFIER_ID);
            if (!mainIdentifier.equals(OID_ENCRYPTED_DATA)) {
                throw new CryptoException("Given data is not encrypted CMS.");
            }
            // parse the encrypted object
            DERTaggedObject encryptedObject = (DERTaggedObject) mainSequence.getObjectAt(ASN1CONTENT_ID);
            // parse the sequence containing the useful informations
            ASN1Sequence encryptedSequence = (ASN1Sequence) encryptedObject.getObject();
            // create the content info object
            EncryptedContentInfo info = EncryptedContentInfo.getInstance(encryptedSequence
                    .getObjectAt(ASN1CONTENT_ID));

            return info;
        } catch (IOException e) {
            // if the main sequence can not be read from the stream an IOException would be thrown
            throw new CryptoException(e);
        } catch (ClassCastException e) {
            // if the parsing fails, a ClassCastException would be thrown
            throw new CryptoException(e);
        } catch (IllegalStateException e) {
            // if the parsing fails, also a IllegalStateException can be thrown
            throw new CryptoException(e);
        }
    }