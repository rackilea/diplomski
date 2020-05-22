public static boolean show(Context c)
    {
        ApplicationInfo ai = c.getApplicationInfo();
        String basis = ai.loadLabel(c.getPackageManager()).toString();
        try {
            PackageInfo pi = c.getPackageManager().getPackageInfo(c.getPackageName(), PackageManager.GET_META_
DATA);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
            String lastVersion = prefs.getString("lastversion", null);
            SharedPreferences.Editor edit = prefs.edit();
            if(lastVersion == null){
                // save the first installed version so we can check and see when it got installed
                edit.putString("firstversion", String.valueOf(pi.versionCode));
                edit.commit();
            }
            if(lastVersion == null || pi.versionCode > Integer.parseInt(lastVersion)){
                edit.putString("lastversion", String.valueOf(pi.versionCode));
                edit.commit();
                // show it
                Intent i = new Intent(c, WhatsNew.class);
                c.startActivity(i);
                return true;
            }
        } catch (Exception e) {
            android.util.Log.v("WhatsNew", "Exception checking for release notes for [" + basis +
"]:" + e.getMessage(), e);
        }
        return false;
    }