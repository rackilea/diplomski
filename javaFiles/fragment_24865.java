public class Session {
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private String ISLOGIN = "is_logged_in";
    private String USER_ID = "user_id";

    public Session(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);

    }


    public boolean setLogin(boolean status) {
        spEditor = sp.edit();
        spEditor.putBoolean(ISLOGIN, status);
        //use apply for async process
        spEditor.apply();
        return status;
    }

    public boolean getLoggedIn() {
        return sp.getBoolean(ISLOGIN, false);
    }

    public void setUserId(String userid){
        sp.edit().putString(USER_ID,userid).apply();
    }


    //get user id
    public String getUserId(){
       return sp.getString(USER_ID);
    }

}