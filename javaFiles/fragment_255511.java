public boolean isLogin() {

        return pref.getBoolean("login", false);

    }

    public void setLogin(Boolean x) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("login", x);
        editor.commit();
    }