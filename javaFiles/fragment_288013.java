@Override
protected void onPostExecute(String result) {
    if(result.equalsIgnoreCase("login successful")){
        Intent profileIntent = new Intent(MainActivity.this, Profile.class);
            MainActivity.this.startActivity(profileIntent);
    } else {
        alertDialog.setMessage(result);
        alertDialog.show();
    }
}