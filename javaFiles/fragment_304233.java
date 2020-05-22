public class httpGetProduct extends AsyncTask<Void,Void,String> {
        String result, rs;
        JSONArray jArray;
        String itemcode="",price,desc_ar,desc_en;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            isOnline=ping(); // use ping if connecting to a certain local ip address 
    isOnline= hasInternetConnection();// use this if your connecting to internet         
}

        @Override
        protected String doInBackground(Void... params) {
            if(isOnline) // executes only if online 
            try {
                String link = "http://"+ip+"/PriceCheckerWS.asmx/get_product_data?barcode="+barcode;
                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);

                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                result = sb.toString();
                // do somthing with the result if you need it

                rs = "sucessful";
            } catch (Exception e) {
                rs = "Fail";
            }

            return rs;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



        }
    }

public boolean ping() {
        String[] separated = ip.split(":");
        String hostip=separated[0];
        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 " + hostip);
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }

public boolean hasInternetConnection() {
            try {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (cm != null) {
                    NetworkInfo i = cm.getActiveNetworkInfo();
                    if (i != null) {
                        if (!i.isConnected())
                            return false;
                        if (!i.isAvailable())
                            return false;
                    }
                    if (i == null)
                        return false;

                } else
                    return false;
            }
            catch (Exception e){
                return false;
            }
            internet=true;
            return true;
        }