String curl = "http://www.tempsite.com/status/status.txt";
HttpURLConnection httpcon=null;
public String getstatus()
{
    String versionRead="";
    URL url = new URL(curl);
    try{
            if(httpcon==null) 
            {
              httpcon= (HttpURLConnection) url.openConnection();
            }
            httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");

            if(httpcon.getResponseCode()==HTTP_OK)
            {
              BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
              versionRead = in.readLine();
              in.close();
            }
    }
    catch(Exception e)
    {
                System.out.println("Stream may not Closed");
    }
    return versionRead;
}