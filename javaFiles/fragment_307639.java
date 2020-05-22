try {
    int i = 0;

    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("authentication_token", auth_token));
    nameValuePairs.add(new BasicNameValuePair("key", key));
    nameValuePairs.add(new BasicNameValuePair("category_name", category_name));
    nameValuePairs.add(new BasicNameValuePair("type", type[i]));
    nameValuePairs.add(new BasicNameValuePair("page", String.valueOf(page_no)));

    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

    HttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();

    eu = EntityUtils.toString(entity).toString();
} catch (Exception e) {
    Log.e(TAG, e.toString());
}