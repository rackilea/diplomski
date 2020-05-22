@Override
 protected void onProgressUpdate(Integer... values) {
     Log.i("Value", values[0].toString());
     count++;
     progressBar.setProgress(count);
 }