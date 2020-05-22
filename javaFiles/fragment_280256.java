public String executeMultipartPost() throws Exception {
    try {

        ByteArrayOutputStream mByteOutputStream = new ByteArrayOutputStream();

        mSelectedImage.compress(CompressFormat.JPEG, 75, mByteOutputStream);

        byte[] mImageByteDate = mByteOutputStream.toByteArray();

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(CONSTANTS.MAIN_URL_GLOBAL + CONSTANTS.BUSINESS_REGISTRATION_TAG);

        ByteArrayBody mImageByteArray = new ByteArrayBody(mImageByteDate, Long.toString(System.currentTimeMillis()) + ".jpg");

        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

        reqEntity.addPart("logo_img", mImageByteArray);

        reqEntity.addPart("name", new StringBody(txtBusinessName_business_registration.getText().toString()));
        reqEntity.addPart("email", new StringBody(txtBusinessEmail_business_registration.getText().toString()));
        reqEntity.addPart("contact_phone", new StringBody(txtBusinessPhone_business_registration.getText().toString()));
        reqEntity.addPart("link_url", new StringBody(txtBusinessWebsite_business_registration.getText().toString()));
        reqEntity.addPart("Address", new StringBody(txtStreetAddress_business_registration.getText().toString()));
        reqEntity.addPart("City", new StringBody(txtCity_business_registration.getText().toString()));
        reqEntity.addPart("State", new StringBody(txtState_business_registration.getText().toString()));
        reqEntity.addPart("Zip", new StringBody(txtZip_business_registration.getText().toString()));
        reqEntity.addPart("details", new StringBody(txtDetail_business_registration.getText().toString()));
        reqEntity.addPart("products", new StringBody(txtService_business_registration.getText().toString()));

        // Prepare Category Array
        for (String mBusinessID : mSelectedCategoryArray) {
            reqEntity.addPart("CategoryCBG[]", new StringBody(mBusinessID));
        }

        postRequest.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(postRequest);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        String sResponse;
        mStringBuilder = new StringBuilder();

        while ((sResponse = reader.readLine()) != null) {
            mStringBuilder = mStringBuilder.append(sResponse);
        }

        return mStringBuilder.toString();

    } catch (Exception e) {
        e.printStackTrace();
        // handle exception here
        Log.e(e.getClass().getName(), e.getMessage());

        return "error";


  }
    }