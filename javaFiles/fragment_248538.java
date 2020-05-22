public class readtextfile extends AsyncTask<String, Integer, String>{

private TextView textViewToSet;
public readtextfile(TextView descriptionTextView){
    this.textViewToSet = descriptionTextView;
    }

@Override
protected String doInBackground(String... params) {
    String result = "";
    try {
           URL url = new URL("http://example.com/example.txt");       

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;

        while ((line = in.readLine()) != null) {
            //get lines
            result+=line;
        }
        in.close();


        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    return result;
}

 protected void onProgressUpdate() {
    //called when the background task makes any progress
 }

  protected void onPreExecute() {
     //called before doInBackground() is started
 }

@Override
 protected void onPostExecute(String result) {
     this.textViewToSet.setText(result); 
 }
  }