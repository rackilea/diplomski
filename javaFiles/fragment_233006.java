InputStream getAuthenticatedResponse(final String urlStr, final String domain,final String userName, final String password) throws IOException {


            Authenticator.setDefault(new Authenticator() {

                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                        domain + "\\" + userName, password.toCharArray());
                }
            });

            URL urlRequest = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) urlRequest.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "*/*");
            return conn.getInputStream();

        }