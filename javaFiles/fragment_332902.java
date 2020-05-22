public static boolean register(Context myContext, String name, String pwd) {

            byte[] data;
            HttpPost httppost;
            StringBuffer buffer;
            HttpResponse response;
            HttpClient httpclient;
            InputStream inputStream;
            List<NameValuePair> nameValuePairs;

            try {
                    httpclient = new DefaultHttpClient();
                    httppost = new HttpPost(
                                    "http://X.X.X.X/register.php");
                    // Add your data
                    nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("User", name.trim()));
                    nameValuePairs.add(new BasicNameValuePair("Password", pwd.trim()));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    // Execute HTTP Post Request
                    response = httpclient.execute(httppost);
                    inputStream = response.getEntity().getContent();

                    data = new byte[256];

                    buffer = new StringBuffer();
                    int len = 0;
                    while (-1 != (len = inputStream.read(data))) {
                            buffer.append(new String(data, 0, len));
                    }

                    inputStream.close();
            }

            catch (Exception e) {
                    Toast.makeText(myContext, "error" + e.toString(), Toast.LENGTH_LONG)
                                    .show();
                    return false;
            }


            if (buffer.charAt(0) == 'Y') {

                    return true;
            } else {

                    return false;
            }

    }