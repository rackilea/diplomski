private String getOcspUrl(X509Certificate certificate) throws Exception {
    byte[] octetBytes = certificate
            .getExtensionValue(X509Extension.authorityInfoAccess.getId());

    DLSequence dlSequence = null;
    ASN1Encodable asn1Encodable = null;

    try {
        ASN1Primitive fromExtensionValue = X509ExtensionUtil
                .fromExtensionValue(octetBytes);
        if (!(fromExtensionValue instanceof DLSequence))
            return null;
        dlSequence = (DLSequence) fromExtensionValue;
        for (int i = 0; i < dlSequence.size(); i++) {
            asn1Encodable = dlSequence.getObjectAt(i);
            if (asn1Encodable instanceof DLSequence)
                break;
        }
        if (!(asn1Encodable instanceof DLSequence))
            return null;
        dlSequence = (DLSequence) asn1Encodable;
        for (int i = 0; i < dlSequence.size(); i++) {
            asn1Encodable = dlSequence.getObjectAt(i);
            if (asn1Encodable instanceof DERTaggedObject)
                break;
        }
        if (!(asn1Encodable instanceof DERTaggedObject))
            return null;
        DERTaggedObject derTaggedObject = (DERTaggedObject) asn1Encodable;
        byte[] encoded = derTaggedObject.getEncoded();
        if (derTaggedObject.getTagNo() == 6) {
            int len = encoded[1];
            return new String(encoded, 2, len);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}