String password = "my_password";
    KeyStore.ProtectionParameter pwParam = new KeyStore.PasswordProtection(password.toCharArray());
    KeyStore keystore = KeyStore.getInstance("PKCS12");
    System.out.println("keystore classname: " + keystore.getClass().getName());
    FileInputStream fileStream = new FileInputStream("certificate_file.p12");
    keystore.load(fileStream, password.toCharArray());
    for (Enumeration<String> e = keystore.aliases(); e.hasMoreElements(); ) {
            String alias = e.nextElement();
            System.out.println("*** entry name: " + alias);
            KeyStore.Entry entry = keystore.getEntry(alias, pwParam);
            System.out.println("entry as string: " + entry.toString());
            for (Certificate cert: keystore.getCertificateChain(alias)) {
                    System.out.println("*** cert: " + cert);
            }
    }