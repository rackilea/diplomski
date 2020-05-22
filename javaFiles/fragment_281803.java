String tmpdir = System.getenv("CATALINA_TMPDIR");
        if(tmpdir == null)
            tmpdir = System.getenv("CATALINA_HOME") + "/temp";
        final String tmpJKSfile = tmpdir + "/ldap.jks";
        URL ts = getClass().getResource("/ldap.jks");
        try {
            InputStream in = new BufferedInputStream(ts.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(tmpJKSfile));
            IOUtils.copy(in, out);
            out.flush();
            out.close();
            in.close();
        } catch (IOException eio) {
            /* your logging */
        }


        System.setProperty(TrustStoreProperty, tmpJKSfile);