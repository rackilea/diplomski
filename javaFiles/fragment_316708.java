// create certificate chain from detached signature
byte[] detachedSignatureContent = documentDetachedSignature.getSignature(); // this is the detached signature file content received from the remote server which contains also customer the certificate
ExternalSignatureContainer externalSignatureContainer = new CustomExternalSignature(detachedSignatureContent);

// add signature content to existing signature container of the intermediary PDF document
PdfReader pdfReader = new PdfReader(preSignedDocumentContent);// this is the value from 1st step for ***PRESIGNED_CONTENT****
ByteArrayOutputStream signedPdfOutput = new ByteArrayOutputStream();
MakeSignature.signDeferred(pdfReader, "Signature_" + customerExternalId, signedPdfOutput, externalSignatureContainer);

return signedPdfOutput.toByteArray();