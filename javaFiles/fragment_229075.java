DERApplicationSpecific app = (DERApplicationSpecific) obj;
ASN1Sequence seq = (ASN1Sequence) app.getObject(BERTags.SEQUENCE);
Enumeration secEnum = seq.getObjects();
while (secEnum.hasMoreElements()) {
    ASN1Primitive seqObj = (ASN1Primitive) secEnum.nextElement();
    System.out.println(seqObj);
}