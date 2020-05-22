//In doInBackground

try {
    BufferedReader reader = new BufferedReader(new InputStreamReader(webs,"iso-8859-1"),8);
    resultText = reader.readLine();
    webs.close();
} catch(Exception e){
    resultText = "HI";
}
.  
.
.
// onPostExecute method
protected void onPostExecute(String str) {
    mTextView.setText(resultText);
}