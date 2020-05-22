String alias = aliases.nextElement();
if (keyStore.isCertificateEntry(alias)) { // keep only trusted cert entries
    Certificate caCert = keyStore.getCertificate(alias)
    byte[] extraCertificate = caCert.getEncoded();
    Intent installIntent = KeyChain.createInstallIntent();
    installIntent.putExtra(KeyChain.EXTRA_CERTIFICATE, extraCertificate);
    installIntent.putExtra(KeyChain.EXTRA_NAME, MY_CERT);
    startActivityForResult(installIntent, INSTALL_KEYCHAIN_CODE);
}