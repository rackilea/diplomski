private class DownloadFilesTask extends AsyncTask<String, List<Product>, Integer> {
     protected List<Products> doInBackground(String... requestStrings) {
        int count = requestStrings.length;
        int results = 0;
        for (int i = 0; i < count; i++) {
          String requestString = requestStrings[i];
          HttpGet httpGet = new HttpGet(requestString);
          httpGet.addHeader("Accept", "text/xml");
          String encodingString = "testuser:testpass";
          String sEncodedString = Base64Coder.encodeString(encodingString);
          try{
            String sContent = fetchURL(requestString, sEncodedString);
            XMLParser xmlParser = new XMLParser();
            List <Product> products = xmlParser.getProducts(sContent);
            results++;
            publishProgress(products);
          }
          catch(Exception ex){
            Log.e(TAG, ex.getMessage());
          }
        }
        return results;
     }

     protected void onProgressUpdate(Integer... progress) {
         // TODO You are on the GUI thread, and the first element in 
         // the progress parameter contains the last progress
         // published from doInBackground, so update your GUI
     }

     protected void onPostExecute(int result) {
       // Processing is complete, result contains the number of 
       // results you processed
     }
 }