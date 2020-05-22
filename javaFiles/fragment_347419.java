new AsyncTask<Void,Void,String>(){

    @Override
    protected void onPreExecute()
    {
      super.onPreExecute()
      // runs on the ui thread
      // show dialog
    }  
    @Override
    protected String doInBackground(Void... params) {
        try {
            PostBase postBase = new PostBase();
            statusCode = postBase.POST(postModel);
            if(statusCode == 201){
              return "successful";
            }else {
              return "notsuccessful"
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "something";
    }

    @Override
    protected void onPostExecute(String result)
    {
      super.onPostExecute();
      // dismiss dialog
      if(result.equals("successful")
      {
        // do something on successful
        // runs on the ui thread so do update ui
      }
    }   
}.execute();