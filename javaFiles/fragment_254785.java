String advice = ""; 

class MySyncTask extends AsyncTask<Integer, Integer, String>{
@Override
protected String doInBackground(Integer... params) {
       try{
           Socket s = new Socket("127.0.0.1", 4242);
           InputStreamReader streamReader = new InputStreamReader(s.getInputStream()); 
           BufferedReader reader = new BufferedReader(streamReader);
           advice = reader.readLine();
           reader.close();
        }catch(Exception ex)
            ex.printStackTrace();
        }
        return advice;
    }

    protected void onPostExecute(String result) {
         tv.setText("Today you should: " + advice);
    }
    protected void onPreExecute() {
       log.i("start");
    }    
}