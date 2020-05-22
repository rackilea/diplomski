protected String doInBackground(String... connUrl){
    HttpURLConnection conn = null;
    BufferedReader reader;
    StringBuilder sb;

    try{
        final URL url = new URL(connUrl[0]);
        conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Content-Type", "application/json; 
charset=utf-8");
        conn.setRequestMethod("GET");
        int result = conn.getResponseCode();
        if(result == 200){

            InputStream in = new BufferedInputStream(conn.getInputStream());
            reader = new BufferedReader(new InputStreamReader(in));
            sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

        }

    }catch(Exception ex){

    }
    return sb.toString();
    }
    protected void onPostExecute(String result){
       super.onPostExecute(result);
       System.out.println(result);
    }