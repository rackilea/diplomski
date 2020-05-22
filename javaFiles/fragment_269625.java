// long term validation (LTV)
List<CrlClient> crlList = new ArrayList<>();

for(Certificate cert : chain) {
    X509Certificate c = (X509Certificate)cert;
    List<String> crls = this.getCrlDistributionPoints(c);
    if(crls != null && !crls.isEmpty()) {
        crlList.add(new CrlClientOnline(crls.toArray(new String[crls.size()])));
    }
}

private List<String> getCrlDistributionPoints(final X509Certificate cert) throws Exception {
    final byte[] crldpExt = cert.getExtensionValue(X509Extension.cRLDistributionPoints.getId());
    if (crldpExt == null) {
        final List<String> emptyList = new ArrayList<String>();
        return emptyList;
    }
    ASN1InputStream oAsnInStream = null;
    ASN1InputStream oAsnInStream2 = null;
    List<String> crlUrls = new ArrayList<String>();

    try { 
        oAsnInStream = new ASN1InputStream(new ByteArrayInputStream(crldpExt));
        final ASN1Object derObjCrlDP = oAsnInStream.readObject();
        final DEROctetString dosCrlDP = (DEROctetString) derObjCrlDP;
        final byte[] crldpExtOctets = dosCrlDP.getOctets();
        oAsnInStream2 = new ASN1InputStream(new ByteArrayInputStream(crldpExtOctets));
        final ASN1Object derObj2 = oAsnInStream2.readObject();
        final CRLDistPoint distPoint = CRLDistPoint.getInstance(derObj2);
        for (final DistributionPoint dp : distPoint.getDistributionPoints()) {
            final DistributionPointName dpn = dp.getDistributionPoint();
            // Look for URIs in fullName
            if (dpn != null) {
                if (dpn.getType() == DistributionPointName.FULL_NAME) {
                    final GeneralName[] genNames = GeneralNames.getInstance(dpn.getName()).getNames();
                    // Look for an URI
                    for (int j = 0; j < genNames.length; j++) {
                        if (genNames[j].getTagNo() == GeneralName.uniformResourceIdentifier) {
                            final String url = DERIA5String.getInstance(genNames[j].getName()).getString();
                            crlUrls.add(url);
                        }
                    }
                }
            }
        }
    } catch(IOException e) {
        throw new Exception(e.getMessage(), e);
    } finally {
        IOUtils.closeQuietly(oAsnInStream);
        IOUtils.closeQuietly(oAsnInStream2);
    }

    return crlUrls;
}