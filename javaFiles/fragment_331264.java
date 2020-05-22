System.setProperty("proxySet", "true");
    System.setProperty("proxyHost", "myproxy");
    System.setProperty("proxyPort", "myport");

    Authenticator.setDefault(new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            System.out.printf("url=%s, host=%s, ip=%s, port=%s%n", getRequestingURL(),
                    getRequestingHost(), getRequestingSite(), getRequestingPort());

            return new PasswordAuthentication("emily@socialcast.com", "demo".toCharArray());
        }
    });

    URL url = new URL("https://demo.socialcast.com/api/users");
    System.out.println(new Scanner(url.openStream()).useDelimiter("\\Z").next());