public class get_key extends AsyncTask<String, String, String> {

ProgressDialog dialog;

    @Override
    protected void onPreExecute (){
    //Show Dialog Here
        super.onPreExecute ();
    }


    @Override
    protected String doInBackground (String... params){

    // Do Network Calling
    return string;
    }

    @Override
    protected void onPostExecute (String result){

     if(dialog.isShowing()){
     dialog.dismiss();
     }
    // put condition to check data
    api_key_from_network=reuslt;
    }
 }