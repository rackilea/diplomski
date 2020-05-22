CMSTypedData cmsBytes = new CMSProcessableByteArray(sd.getEncoded());
byte[] bytes = (byte[]) cmsBytes.getContent();

// reconstruct CMSSignedData from the byte array
ContentInfo ci = ContentInfo.getInstance(ASN1Sequence.fromByteArray(bytes));
CMSSignedData sig = new CMSSignedData(ci);