public class GetJson  extends AsyncTask<Void,Void,String> {
String  JSON_STRING;
String json_url;
public String pasString;
Activity ab;

// this is new code
ResponseListener listener;
public void setOnResponseListener(ResponseListener listener) {
    this.listener = listener;
}

@Override
protected void onPreExecute() {
    json_url="https://XXXXXXX.000webhostapp.com/Json_getData_Survey.php";
}

// now add this code in onPost function

@Override
protected void onPostExecute(String result) {

   pasString=result;
   listener.onResponseReceive(pasString);

  // Toast.makeText(ab,pasString,Toast.LENGTH_LONG).show();
  // json_string1=result;
}