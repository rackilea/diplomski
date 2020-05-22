HttpClient httpclient = new DefaultHttpClient();    
         HttpPost httppost = new HttpPost("http://Your URL/");      
        try {        
         // Add your data        
         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);        
         nameValuePairs.add(new BasicNameValuePair("Name1", "Value1"));        
         nameValuePairs.add(new BasicNameValuePair("Name2", "Value2"));     
         nameValuePairs.add(new BasicNameValuePair("Name3", "Value3"));    

          httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));          
        // Execute HTTP Post Request        
         HttpResponse response = httpclient.execute(httppost);             
         } 
        catch (ClientProtocolException e) 
        {       
         // TODO Auto-generated catch block    
         } 
        catch (IOException e) 
        {         
        // TODO Auto-generated catch block  
          }