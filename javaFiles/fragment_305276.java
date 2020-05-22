mJsonString = downloadFileFromInternet(urls[0]);

if(mJsonString == null)
    return false;

JSONObject jObject = null;
jObject = new JSONObject(mJsonString);

----

    private String downloadFileFromInternet(String url)
        {
            if(url == null /*|| url.isEmpty() == true*/)
                new IllegalArgumentException("url is empty/null");
            StringBuilder sb = new StringBuilder();
            InputStream inStream = null;
            try
            {
                url = urlEncode(url);
                URL link = new URL(url);
                inStream = link.openStream();
                int i;
                int total = 0;
                byte[] buffer = new byte[8 * 1024];
                while((i=inStream.read(buffer)) != -1)
                {
                    if(total >= (1024 * 1024))
                    {
                        return "";
                    }
                    total += i;
                    sb.append(new String(buffer,0,i));
                }
            }catch(Exception e )
            {
                e.printStackTrace();
                return null;
            }catch(OutOfMemoryError e)
            {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        }

        private String urlEncode(String url)
        {
            if(url == null /*|| url.isEmpty() == true*/)
                return null;
            url = url.replace("[","");
            url = url.replace("]","");
            url = url.replaceAll(" ","%20");
            return url;
        }