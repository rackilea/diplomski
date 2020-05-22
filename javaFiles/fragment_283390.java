SortedSet<String> allLanguages = new TreeSet<String>();
String[] languages = Locale.getISOLanguages();
for (int i = 0; i < languages.length; i++){
    Locale loc = new Locale(languages[i]);
    allLanguages.add(loc.getDisplayLanguage());
}