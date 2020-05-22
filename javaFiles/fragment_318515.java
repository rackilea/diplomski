@Override
protected String doInBackground(Void... params) {
    internetHandler ih = new internetHandler();
    values = ih.getList(usernameString,passwordString,"","");
    return values[0];    
}

@Override
protected void onPostExecute(String result) {
   if(!result.equalsIgnoreCase("error") && !result.equalsIgnoreCase("401") && !result.equalsIgnoreCase("404")){
        userPass.setText("Yep");
    }else{
        userPass.setText(result);
    }
}