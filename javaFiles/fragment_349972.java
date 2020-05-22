X509Certificate certificate = signature.getKeyInfo().getX509Datas().get(0).getX509Certificates().get(0);

        if (certificate != null) {
            //Converts org.opensaml.xml.signature.X509Certificate to java.security.cert.Certificate
            String lexicalXSDBase64Binary = certificate.getValue();
            byte[] decoded = DatatypeConverter.parseBase64Binary(lexicalXSDBase64Binary);

            try {
                CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
                Certificate cert = certFactory.generateCertificate(new ByteArrayInputStream(decoded));
                return cert;