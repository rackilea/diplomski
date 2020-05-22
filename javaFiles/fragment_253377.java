// This class is just added somewhere in your main activity, like a function.
 private class PostFormTask extends AsyncTask<String, Integer, Long> {

     protected Long doInBackground(String... queryDetails) {

     try{

            String httpsURL = "https://example.com/apis/submit_credit_application.php";

            String query = "fname="+URLEncoder.encode(queryDetails[0],"UTF-8"); 
            query += "&lname="+URLEncoder.encode(queryDetails[1],"UTF-8");
            query += "&addr="+URLEncoder.encode(queryDetails[2],"UTF-8");
            // Keep adding to your query but instead of getting your details
            // from the textview they are in the queryDetails array.


            URL myurl = new URL(httpsURL);
            HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-length", String.valueOf(query.length())); 
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
            con.setDoOutput(true); 
            con.setDoInput(true); 

            DataOutputStream output = new DataOutputStream(con.getOutputStream());  
            output.writeBytes(query);
            output.close();


        }catch(IOException e){

            Toast.makeText(
                getApplicationContext(),
                (CharSequence) e, 
                Toast.LENGTH_LONG
            ).show();

        }
         return false
     }

     protected void onPostExecute(Long result) {

     }
 }