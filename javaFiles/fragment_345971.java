String postReceiverUrl = "http://URL/upload.php";
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(postReceiverUrl);

        //Create File
        File file = new File("/path_to_file/test.txt");
        FileBody fileBody = new FileBody(file);

        //Set up HTTP post
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        reqEntity.addPart("MyTxtFile", fileBody);

        httpPost.setEntity(reqEntity);

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity resEntity = response.getEntity();

        if (resEntity != null) {

            String responseStr = EntityUtils.toString(resEntity).trim();

            System.out.println(responseStr);
            System.out.println(response.getStatusLine());
        }