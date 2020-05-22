class FetchWebsiteData extends AsyncTask<Void, Void, String[]> {
    protected String[] doInBackground(Void... params) {
        ArrayList<String> hrefs=new ArrayList<String>();
        try {
            // Connect to website                
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parsing first URL
        try {

            //listValue=colValue.text();
            String subString=colValue.text();
            String[] result=subString.split("(?<=[a-z])\\.(?=\\s*[A-Z])|[,:]");
            return result;
            //expose all array values
            //listValue=result[1];
            /*
            for(int i=0;i<result.length;i++)
            {
                 listValue=result[0];
             }*/

         } catch (IOException e) {
              e.printStackTrace();
         }
        return null;
    }
    protected void onPostExecute(String[] result) {            
        ListView list=(ListView)findViewById(R.id.listShow);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(PrimaryActivity.this, android.R.layout.simple_list_item_1, result);
        list.setAdapter(arrayAdapter);
        mProgressDialog.dismiss();
    }
}