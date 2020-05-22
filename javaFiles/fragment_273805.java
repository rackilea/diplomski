HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://10.0.2.2/json.php/");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            Log.e("", "" + conn.getResponseMessage());
            conn.connect();
            JSONObject obj = new JSONObject();
            obj.put("Marge","Simpson");

            HttpClient client = new DefaultHttpClient();

            StringBuilder pat = new StringBuilder();
            HttpGet post = new HttpGet(url.toURI());
            post.setEntity(new     ByteArrayEntity(obj.toString().getBytes("UTF8")));
            post.setHeader("json", obj.toString());
            post.setHeader("Content-Type", "application/json");
            post.setHeader("accept-encoding","gzip, deflate");
            post.setHeader("accept-language","en-US,en;q=0.8");
            post.setHeader("FormData",obj.toString());

            HttpResponse lazy = client.execute(post);
            HttpEntity ent = lazy.getEntity();
            String lb = EntityUtils.toString(ent);
            pat.append(lb);
            Log.i("Read from server", pat.toString());

        } catch (Exception e){
            e.printStackTrace();
        }finally {

            if (conn != null)
                conn.disconnect();

            try{
                if (reader != null)
                    reader.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;