private void storeCurrentActivity(){ 
        SharedPreferences myPref =getSharedPreferences("APP_SHARED_PREF",            Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor = myPref.edit(); 
        editor.clear(); 
        String packageName = this.getPackageName(); 
        String className = this.getClass().getSimpleName(); 
        editor.putString("lastactivity",packageName+"."+className); 
        editor.commit(); 
}