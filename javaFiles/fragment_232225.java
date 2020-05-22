String title;

public void setTitle(String title) {
  this.title = title;
}

protected void onPostExecute(Float result) {
  AlertDialog.Builder alertbox = new AlertDialog.Builder(Vacation.this);
  alertbox.setMessage(title);
  // ...
}