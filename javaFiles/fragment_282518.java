//in your both activity or create class 

    private SharedPreferences mSharedPreferences;


//in your login on getLogin() method ;

    mSharedPreferences = getSharedPreferences("user_preference",Context.MODE_PRIVATE);
        //save actual drawable id in this way.

       if(mSharedPreferences==null)
            return;

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("userId", loginBean.getUser_id());
        editor.commit();


// in your after login acvtivity on deliverable method

    private SharedPreferences mSharedPreferences;

mSharedPreferences = getSharedPreferences("user_preference",Context.MODE_PRIVATE);
if(mSharedPreferences==null)
            return;
string userId = mSharedPreferences.getString("userId", "");