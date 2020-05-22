// initialize a new TMF with our keyStore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX", "SunJSSE");

        CertPathParameters pkixParams = new PKIXBuilderParameters(keyStore, new X509CertSelector());

        // Activate certificate revocation checking
        ((PKIXBuilderParameters) pkixParams).setRevocationEnabled(true);

        List<CertStore> certStores = new ArrayList<>(1);

        Collection<CRL> crls = new HashSet<>(1);
        crls.add(CertificateFactory.getInstance("X.509").generateCRL( new java.io.FileInputStream("your_local_file.crl")));

        certStores.add(CertStore.getInstance("Collection", new CollectionCertStoreParameters(crls)));
        ((PKIXBuilderParameters) pkixParams).setCertStores(certStores);

        System.setProperty("com.sun.security.enableCRLDP", "true");
        tmf.init(new CertPathTrustManagerParameters(pkixParams));

        // acquire X509 trust manager from factory
        TrustManager tms[] = tmf.getTrustManagers();
        for (TrustManager tm : tms) {
            if (tm instanceof X509TrustManager) {
                trustManager = (X509TrustManager) tm;
                break;
            }
        }