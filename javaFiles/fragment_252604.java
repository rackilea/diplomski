private String uploadFile (String filePath, String HTML) throws Exception {

        String postUrl = getUploadUrl(HTML);
        postUrl = "http://printing.**.ca:9191" + postUrl;
        HttpPost post = new HttpPost(postUrl);

        HttpClient client = new DefaultHttpClient();

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        String random = "";
        Random ran = new Random();
        for (int i = 0; i < 28; i++) {
            random = random + String.valueOf(ran.nextInt(9));
        }
        String boundary = "---------------------------" + random; 

        final File file = new File(filePath);

        FileBody fb = new FileBody(file, ContentType.create("application/vnd.ms-excel"), "hello.xls");

        builder.addPart("file[];", fb);
        builder.setBoundary(boundary);

        post.setEntity(builder.build());

        post.setHeader("Host", "printing.**.ca:9191");
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        post.setHeader("Accept-Language", "en-US,en;q=0.5");
        post.setHeader("Referer",
                "http://printing.**.ca:9191/app");
        post.setHeader("Connection", "keep-alive");
        for (String cookie : this.cookies) {
            for (String c : cookie.split(";")) {
                if (c.contains("JSESSION")) {
                    post.setHeader("Cookie", c);
                }
            }
        }

        HttpResponse response = client.execute(post);
        String reply = sendPost("http://printing.**.ca:9191/app", getUploadParameters(HTML));

        return response.toString();
    }