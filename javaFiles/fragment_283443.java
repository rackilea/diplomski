public void login(String usernameInput, String passwordInput) {
        boolean exist = false;
        try{
            for(int i=0; i<= listOfMaps.size(); i++){
                if(listOfMaps.get(i).get("username").equals(usernameInput) && listOfMaps.get(i).get("password").equals(passwordInput)){
                    exist = true;

                    // save in shared preferences
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", listOfMaps.get(i).get("username"));
                    editor.putString("password", listOfMaps.get(i).get("password"));
                    editor.putString("id", listOfMaps.get(i).get("id") );
                    editor.putString("photo", listOfMaps.get(i).get("photo") );
                    editor.commit();

                    break;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(exist){
            Intent i = new Intent(this, PostsActivity.class);
            startActivity(i);
            finish();
        }else {
            login_btn.setEnabled(false);
        }
    }