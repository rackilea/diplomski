String keystring = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("target_hostkey","");

if(!Strings.isNullOrEmpty(keystring)){
    byte[] key = Base64.decode ( keystring, Base64.DEFAULT );
    jsch.getHostKeyRepository().add(new HostKey("github.com", key ), null);
}