List<String> selectedCertificates = new ArrayList<String>();
selectedCertificates.addAll(selectedTypeACertificates);
selectedCertificates.addAll(selectedTypeBCertificates);

StringBuilder sb = new StringBuilder();
for (String cert : selectedCertificates)
{
    sb.append(cert);
    sb.append("','");
}

String certificatesString = sb.toString();
if(!certificatesString.isEmpty()) {
    certificatesString = "'" + certificatesString.substring(0, certificatesString.lastIndexOf(",")) + "'";
}