Video v = new Video();
v.setSource(new StreamResource(new StreamSource() {

    @Override
    public InputStream getStream() {
        try {
            URL url = new URL(Constants.VIDEO_HTTP_ADDRESS + fileName + ".mp4");
            URLConnection uc = url.openConnection();
            String userpass = Constants.VIDEO_HTTP_ADDRESS_USERNAME + ":" + Constants.VIDEO_HTTP_ADDRESS_PASSWORD;
            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
            uc.setRequestProperty("Authorization", basicAuth);
            return uc.getInputStream();
        } catch (IOException e) {
            //add some exception handling here
        }
    }

}, fileName + ".mp4"));