void sign(PDDocument document, OutputStream output, SignatureInterface signatureInterface) throws IOException
{
    PDSignature signature = new PDSignature();
    signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);
    signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
    signature.setName("Example User");
    signature.setLocation("Los Angeles, CA");
    signature.setReason("Testing");
    signature.setSignDate(Calendar.getInstance());
    document.addSignature(signature);
    ExternalSigningSupport externalSigning =
            document.saveIncrementalForExternalSigning(output);
    byte[] cmsSignature = signatureInterface.sign(externalSigning.getContent());
    externalSigning.setSignature(cmsSignature);
}