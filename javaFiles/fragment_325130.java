System.setProperty("weblogic.security.SSL.ignoreHostnameVerification","true");
        System.setProperty("java.protocol.handler.pkgs", "weblogic.net");
        System.setProperty("weblogic.security.TrustKeyStore","CustomTrust");
        System.setProperty("weblogic.security.CustomTrustKeyStoreFileName", "<keystorelocation>");
        System.setProperty("weblogic.security.CustomTrustKeyStorePassPhrase","<keystorepassword>"); 
        System.setProperty("weblogic.security.CustomTrustKeyStoreType","JKS");