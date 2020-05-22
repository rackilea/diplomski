public boolean sendToLogsAPI(ArrayList<String> logList) throws IOException
{
    DataOutputStream wr = null;
    HttpURLConnection conn = null;

    try 
    {
         for(int i=0; i<logList.size(); i++)
         {
             conn = conn("<Some-URL>","<API-Key>","<GUID>");
             wr = new DataOutputStream(conn.getOutputStream());
             wr.writeBytes(logList.get(i));
             wr.flush();
             int nothing = conn.getResponseCode();
             String morenothing = conn.getResponseMessage();
         }   
         if(wr != null) {
             wr.close();
         }
    }
    catch (Exception e) 
    {
      e.printStackTrace();
    } 
    finally 
    {
      if(conn != null) 
      {
        conn.disconnect(); 
      }
    }

    return false;
}