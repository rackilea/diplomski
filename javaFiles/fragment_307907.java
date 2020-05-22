protected boolean isUserSignedIn(){
    boolean isLoggedIn = false;

    SharedPreferences pref = getSharedPreferences("userSession", Activity.MODE_PRIVATE);
    isLoggedIn = pref.getBoolean("isLoggedIn", false);//false is just default

    return isLoggedIn;
}