ParseQuery<ParseObject> query = ParseQuery.getQuery("DownloadData");
query.getInBackground("parse_object_id", new GetCallback<ParseObject>() {
public void done(ParseObject downloadData, ParseException e) {
if (e == null) {
  // This object will contain your file
   ParseFile downloadFile = (ParseFile) downloadData.get("File");
    downloadFile.getDataInBackground(new GetDataCallback() {
        @Override
        public void done(byte[] bytes, ParseException e) {
            if (e == null) {
                String x= new String(bytes);
                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("Downloaded File")
                        .setMessage(x)
                        .setPositiveButton("Ok", null)
                        .show();
            } else {
                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("Download File")
                        .setMessage("An Error Occurred")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        }
    });
 } else {
  // something went wrong
  }

});