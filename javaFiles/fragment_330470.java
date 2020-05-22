try {
            con = createPackageContext("com.app1", 0);//first app package name is "com.sharedpref1"
            SharedPreferences pref = con.getSharedPreferences(
                        "pref1", Context.MODE_PRIVATE);
            String your_data = pref.getString("stringDemo1", "No Value");
        } 
    catch (NameNotFoundException e) {
                Log.e("Not data shared between two applications", e.toString());
         }