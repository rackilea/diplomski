String redirect = urlConnection.getHeaderField("Location");
        if(redirect != null)    //truth before ICS
        {
            urlConnection.disconnect();

            urlConnection = (HttpsURLConnection) (new URL(redirect)).openConnection();
            urlConnection.setRequestProperty("User-Agent", userAgent);
            urlConnection.setRequestProperty("Cookie", cookie);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            urlConnection.setSSLSocketFactory(getSocketFactory());

            OutputStream os2 = urlConnection.getOutputStream();
            BufferedWriter writer2 = new BufferedWriter(
                    new OutputStreamWriter(os2, "UTF-8"));
            writer2.write(postData);
            writer2.flush();
            writer2.close();
            os2.close();

            urlConnection.connect();
        }