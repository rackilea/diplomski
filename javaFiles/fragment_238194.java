CertificateExtensions exts = /* build the extensions set you want to include */
/* Wrap the extensions set into a SET OF */
OutputStream out = new ByteArrayOutputStream();
exts.encode(out);
DerValue val = new DerValue(DerValue.tag_SetOf, out.toByteArray());
PKCSAttribute extReq = new PKCSAttribute(new ObjectIdentifier("1.2.840.113549.1.9.14"), val.toByteArray());
PKCSAttributes attrs = new PKCSAttributes(new PKCSAttribute[] { extReq });
CertificationRequestInfo cri = new CertificationRequestInfo(subject, key, attrs);
CertificationRequest csr = new CertificationRequest(cri);