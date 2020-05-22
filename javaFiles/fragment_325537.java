webClient.setWebConnection(new HttpWebConnection(webClient) {
        public WebResponse getResponse(WebRequestSettings settings) throws IOException {
            System.out.println(settings.getUrl());
            return super.getResponse(settings);
        }
    });