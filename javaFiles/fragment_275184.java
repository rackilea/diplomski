Comparator<String> sortByPreferenceKey = new Comparator<String>(){
    public int compare(String o1, String o2) {
        // Put your comparison logic here
    }
};
SharedPreferences pref = context.getSharedPreferences("myPrefs2", MODE_PRIVATE);
TreeMap<String, Object> keys = new TreeMap<String, Object>(sortByPreferenceKey);
keys.putAll(pref.getAll());