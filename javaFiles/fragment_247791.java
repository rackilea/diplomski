@Override
    protected String doInBackground(Void... params) {
        String retorno = null;
        try {

            URL url = new URL(SERVER_ADDRESS + "yourphpfile.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("Value1", this.CodServico+"")
                    .appendQueryParameter("Image", this.ba);
            Log.i("IMAGEM",""+this.ba);
            final String postParameters = builder.build().getEncodedQuery();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("POST");
            conn.setFixedLengthStreamingMode(postParameters.getBytes().length);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //send the POST out
            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.print(postParameters);
            pw.close();
            conn.connect();
            String result = convertStreamToString(conn.getInputStream());
            JSONObject jObject = new JSONObject(result);
            if(jObject.length()!=0){
                retorno= jObject.getString("status");// if was sucess or not
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }