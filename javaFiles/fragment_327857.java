final String message = "http://cs-server.usc.edu:12695/examples/servlet/Moviefb?title=batman&title_type=feature";

new AsyncTask<Void, Void, String>() {
    private String mErrDesc = null;

    @Override
    protected String doInBackground(Void... paramArrayOfParams) {
       URL website;
       String str1 = null;

       try {
           website = new URL(message);
           URLConnection connection = website.openConnection();

           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

           String inputLine;
           while ((inputLine = in.readLine()) != null) 
               str1 += inputLine;

        } catch (MalformedURLException e1) {
            mErrDesc = "MalformedURLException thrown";
            e1.printStackTrace();
            return null;
        } catch (Exception e) {
            mErrDesc = "Exception thrown";
            e.printStackTrace();
            return null;
        }

        return str1;
    }

    @Override 
    protected void onPostExecute(String str) {
        if (str != null)
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        else if (mErrDesc != null) 
            Toast.makeText(getBaseContext(), mErrDesc, Toast.LENGTH_LONG).show();
        else 
            Toast.makeText(getBaseContext(), "Unknown error", Toast.LENGTH_LONG).show();
    }

}.execute();