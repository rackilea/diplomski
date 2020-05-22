private void saveCats(){
    //get your ArrayList from wherever (either as a global variable or pass it into the
    //method.
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < masterCats.size(); i++){
        if(i == masterCats.size() - 1)
            sb.append(masterCats.get(i));
        else
            sb.append(masterCats.get(i)+",");
    }

    SharedPreferences.Editor prefsEditor =
        PreferenceManager.getDefaultSharedPreferences(this).edit();
    prefsEditor.putString("MasterCats", sb.toString()).commit();

    //Note: in API 11 and beyond you can store a Set of Strings in SharedPreferences, so
    //if you are only targeting API 11+ you could do:
    Set<String> masterCatsSet = new LinkedHashSet<String>(); //<--using LinkedHashSet to preserve order
    masterCatsSet.addAll(masterCats);
    prefsEditor.putStringSet("MasterCats",masterCatsSet).commit();
}