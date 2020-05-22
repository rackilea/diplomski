protected void onPostExecute(Boolean result) {
    Intent i= new Intent();
    i.setClass(LoginActivity.this, Copy.class);  
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
    getApplicationContext().startActivity(i);
}