@Override
    public boolean isFirst1000() {
        byte[] data;
        HttpPost httppost;
        StringBuffer buffer = new StringBuffer();
        HttpResponse response;
        HttpClient httpclient;
        InputStream inputStream;

        try {
                httpclient = new DefaultHttpClient();
                httppost = new HttpPost(
                        "http://jaimebeaucouplepain.com/first1000.php");

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
                return false;
        }

        String str = buffer.toString();

        if (str.contains("first1000yes")) {
            return true; // The user is one of the first 1000. We don't have to check again.
        }
        else if (str.contains("first1000no")) {
            return false; // The user is not one of the first 1000. We don't have to check again.
        }
        else {
            return false; // There was an error with the server. We will have to check again (next time the user launches the app for example).
        }
    }