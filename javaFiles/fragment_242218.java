String cn = null;
X509Certificate[] certs = (X509Certificate[]) req
    .getAttribute("javax.servlet.request.X509Certificate");
if (certs != null) {
  String dn = certs[0].getSubjectX500Principal().getName();
  // parse the CN out from the DN (distinguished name)
  Pattern p = Pattern.compile("(^|,)CN=([^,]*)(,|$)");
  cn = p.matcher(dn).find().group(2);
} else {
  // no certificate provided
}