@Override
    protected String doInBackground(String... sUrl) {

        com.google.api.services.drive.model.File body = new com.google.api.services.drive.model.File();
        body.setTitle("some name");
        InputStream input = null;
        InputStreamContent mediaContent = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            if (cookies != null){
                connection.setRequestProperty("Cookie", cookies);
                connection.setRequestProperty("User-Agent", agent);
                connection.setRequestProperty("Accept", "text/html, application/xhtml+xml, *" + "/" + "*");
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.7,he;q=0.3");
                connection.setRequestProperty("Referer", sUrl[0]);
            }
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }

            input = connection.getInputStream();

            mediaContent = new InputStreamContent("", new BufferedInputStream(connection.getInputStream()) {
                @Override
                public int read() throws IOException {

                    return 0;
                }
                @Override
                public int read(byte[] buffer,
                                int byteOffset, int byteCount)
                        throws IOException {

                    return super.read(buffer, byteOffset, byteCount);
                }
            });

            com.google.api.services.drive.model.File f = mService.files().insert(body, mediaContent).execute();

        } catch (Exception e) {
            return e.toString();
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
        }
        return null;
    }