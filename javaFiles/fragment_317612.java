PdfPKCS7 pk = null;
if (sub.equals(PdfName.Adbe_x509_rsa_sha1)) {
    PdfString cert = signature.getPdfObject().getAsString(PdfName.Cert);
    if (cert == null)
        cert = signature.getPdfObject().getAsArray(PdfName.Cert).getAsString(0);
    pk = new PdfPKCS7(PdfEncodings.convertToBytes(contents.getValue(), null), cert.getValueBytes(), provider);
}
else
    pk = new PdfPKCS7(PdfEncodings.convertToBytes(contents.getValue(), null), sub, provider);
updateByteRange(pk, signature);
PdfString date = signature.getDate();
if (date != null)
    pk.setSignDate(PdfDate.decode(date.toString()));
String signName = signature.getName();
pk.setSignName(signName);
String reason = signature.getReason();
if (reason != null)
    pk.setReason(reason);
String location = signature.getLocation();
if (location != null)
    pk.setLocation(location);