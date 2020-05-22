@Override
protected void onPostExecute(String result) {
 //....your code 

  Intent intent = new Intent(CurrentActivity.this,SMSMonitorService.class);     
  intent.putExtra("finalResponse", finalResponse);
  startService(intent);
}