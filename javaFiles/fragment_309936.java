public class LoginOperation extends AsyncTask<String, Void, String> {
    String strusername,strpassword;

    public LoginOperation(String strusername, String strpassword){
        this.strusername=strusername;
        this.strpassword=strpassword;
    }
    @Override
    protected void onPreExecute() {
        //show progressbar here 
    }
    @Override
    protected String doInBackground(String... params) {
        string result="";
        try
        {
            result=="success or fail";
            //do your network opertion here
        }
        catch(SQLException e)
        {
            result="ERROR";
        }
        return result;
    }      

    @Override
    protected void onPostExecute(String resultmsg) {    
        // show error here and update UI
        //or other opertion if login success
        textViewInstance.setText(resultmsg);
    }

}