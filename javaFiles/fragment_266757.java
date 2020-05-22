List<Certificate> certificates = new ArrayList<Certificate>();
Enumeration<String> aliases = keyStore.aliases();
while (aliases.hasMoreElements()) {
    String alias = aliases.nextElement();
    Certificate certificate = keyStore.getCertificate(alias);
    if (certificate != null) {
        certificates.add(certificate);
    }
}