Preference prefereces=findPreference("rateus");
preference.setOnPreferenceClickListener (new Preference.OnPreferenceClickListener(){
    public boolean onPreferenceClick(Preference preference){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.xyz.xyz"));
        startActivity(intent);
        return false;
    }
});