System.setProperty("http.proxyHost", "proxy.****.com");
System.setProperty("http.proxyPort", "####");
 Authenticator authenticator = new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication("user",
                            "PASSWORD".toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);