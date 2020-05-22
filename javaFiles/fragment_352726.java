@Override
protected void onPostExecute(String s) {
    //super.onPostExecute(s);
    String ss = s;
    loadingDialog.dismiss();

    //use equals() instead:
    if(ss.equals("success")) {
        Intent intent = new Intent(MainActivity.this, UserProfile.class);
        intent.putExtra(USER_NAME, username);
        finish();
        startActivity(intent);
    }else{
           Toast.makeText(getApplicationContext(), "invalide username or password", Toast.LENGTH_LONG).show();

    }}
}