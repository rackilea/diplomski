public static byte[] getTokenGss() throws GSSException {

        String spnName = "spn_name";

        String oidValue= "1.2.840.113554.1.2.2"; // KERBEROS_MECH_OID
        String userLogin = System.getProperty("user.name");
        Oid mechOid = new Oid(oidValue);

        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");

        Path directoryConf = "C:\\client\\krb";
        String pathToGssConfigFile = directoryConf.resolve("login.conf").toString();
        System.setProperty("java.security.auth.login.config", pathToGssConfigFile);
        String pathToKrb5ConfigFile = directoryConf.resolve("krb5.conf").toString();
        System.setProperty("java.security.krb5.conf", pathToKrb5ConfigFile);

        System.setProperty("sun.security.krb5.debug", "true");

        GSSManager manager = GSSManager.getInstance();
        GSSName gssUserName = manager.createName(userLogin, GSSName.NT_USER_NAME, mechOid);

        logger.debug("before createCredential");
        GSSCredential clientGssCreds =
                manager.createCredential(gssUserName.canonicalize(mechOid), GSSCredential.INDEFINITE_LIFETIME, mechOid,
                                         GSSCredential.INITIATE_ONLY);

        byte[] token = new byte[0];

        // create target server SPN
        GSSName gssServerName = manager.createName(spnName, GSSName.NT_USER_NAME);
        logger.debug("before createContext");

        GSSContext clientContext = manager.createContext(gssServerName.canonicalize(mechOid), mechOid, clientGssCreds,
                                                         GSSContext.DEFAULT_LIFETIME);

        // optional enable GSS credential delegation
        clientContext.requestCredDeleg(true);
        token = clientContext.initSecContext(token, 0, token.length);
        return token;

    }