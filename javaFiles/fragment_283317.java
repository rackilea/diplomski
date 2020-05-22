Map<String, Extension> unparseables = ((CertificateExtensions)((X509CertInfo)cert.get("x509.info")).get("extensions")).getUnparseableExtensions();

Extension extension = unparseables.get("2.5.29.17");
byte[] value = extension.getValue();
DerValue derValue = new DerValue(value);
while (derValue.data.available() > 0) {
    DerValue encName = derValue.data.getDerValue();
    if ((encName.tag & 0x1f) == 6) {
        encName.resetTag(DerValue.tag_IA5String);
        System.out.printf("IA5String value from URI GeneralName value: %s\n", encName.getIA5String());
    }
}