private class Task extends AsyncTask<Void, Void, Void> 
 { 
    JSONArray myUsers = null;
    JSONObject jsonResponse = null;  // this is also needed at class level

     protected void onPreExecute() {            
         showDialog(DIALOG_TASKING); 
     } 
     protected Void doInBackground(Void... JSONArray) { 

        try
        {
        HttpGet request = new HttpGet(SERVICE_URI + "/GetBusNames");
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();

        char[] buffer = new char[(int)responseEntity.getContentLength()];
        InputStream stream = responseEntity.getContent();       
        InputStreamReader reader = new InputStreamReader(stream);
        reader.read(buffer);
        stream.close();

        jsonResponse = new JSONObject(new String(buffer));
        }
        catch (Exception e) 
        {       
            e.printStackTrace();
            displayExceptionMessage(e.getMessage());
        }
        return null;
    }

    protected void onPostExecute(Void unused) {
        dismissDialog(DIALOG_TASKING);    

 myUsers = jsonResponse.getJSONArray("GetBusNamesResult");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RealestateActivity.this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter.add("Select a Buseness...");                
        for (int i = 0; i < myUsers.length(); ++i)
        {
            adapter.add(myUsers.getString(i));
            adapter.add(myUsers.getJSONObject(i).getString("BusName"));
        }

            userSpinner.setAdapter(adapter); // I get an error here if I wrap these two lines in /*...*/ the whole thing loads as expected but the spinner is empty
            userSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());          
    }