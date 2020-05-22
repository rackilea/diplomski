public class ConnectionClass {


    Context context;
    public ConnectionClass(Context ctx) {
        this.context=ctx;
    }


    public String getServerResponse(String urlLink)
    {

        try 
        {

            HttpClient client = new DefaultHttpClient();
            HttpPost http_get = new HttpPost(url);
            HttpResponse responses;
            responses = client.execute(http_get);
            if (responses != null) 
            {
                InputStream in = responses.getEntity().getContent(); 
                String a = convertStreamToString(in);
               // Log.i("RETURN",a+"");
                return a;
            }

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try
        {
            while ((line = reader.readLine()) != null) 
            {
                sb.append(line);
            }
        } 
        catch (Exception e)
        {

             //Toast.makeText(context, e.toString()+" io2", Toast.LENGTH_LONG).show();
        } 
        finally 
        {
            try 
            {
                is.close();
            } 
            catch (Exception e)
            {

                //Toast.makeText(context, e.toString()+" io3", Toast.LENGTH_LONG).show();
            }
        }
        return sb.toString();
    }

}