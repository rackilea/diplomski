protected void onPostExecute(String result) 
{   
    if(response.equalsIgnoreCase("Success"))
    {
         ResultList_List = prServices_resultList;    
         String[] tmp_dbServ = new String[prServices_resultList.size()];
         String[] tmp_dbServID = new String[prServices_resultList.size()];
         int s=0;
         for (HashMap<String, String> hashServices : prServices_resultList)
         {
             tmp_dbServ[s] = hashServices.get(android_S_CName);                
             tmp_dbServID[s] = hashServices.get(android_S_ID);
             s++;
         }
         Db_Services = tmp_dbServ;
         Db_ServicesID = tmp_dbServID;
    }
}