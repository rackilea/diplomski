ks.load(null, null);
Enumeration<String> en = ks.aliases();
while (en.hasMoreElements()) {
    String aliasKey = en.nextElement();
    X509Certificate c = (X509Certificate) ks.getCertificate(aliasKey);
    System.out.println("alias: " + aliasKey);
    System.out.println("cert:" + c.getSubjectX500Principal().toString());
}