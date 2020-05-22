private static final String CERT_FILE_LOC = "/aaa/bbb/ccffdd.jks";
        System.setProperty("javax.net.ssl.trustStore", CERT_FILE_LOC);


        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: "+urlHostName+" vs. "+session.getPeerHost());

                return true;
            }
        };

        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        URL url = new URL(inputUrl);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        connection.setDoOutput(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = in.readLine()) != null) {
            responseXml=responseXml+line;
            }
        in.close();
        System.out.println("responseXml");