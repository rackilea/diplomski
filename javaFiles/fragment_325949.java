Bitmap bmp =null;
        DefaultHttpClient client = new MyHttpClient(ShowNotification.this);
        HttpGet get = new HttpGet(url);
        HttpResponse getResponse = null;
        try {
            getResponse = client.execute(get);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String entityContents="";
        HttpEntity responseEntity = getResponse.getEntity();
        BufferedHttpEntity httpEntity = null;
        try {
            httpEntity = new BufferedHttpEntity(responseEntity);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        InputStream imageStream = null;
        try {
            imageStream = httpEntity.getContent();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bmp = BitmapFactory.decodeStream(imageStream);

        ImageView imgView =(ImageView)findViewById(R.id.imgView);
        imgView.setImageBitmap(bmp);