//persist
HashMap<String, Integer> counters; //the hashmap you want to save
SharedPreferences pref = getContext().getSharedPreferences("Your_Shared_Prefs", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();    
for (String s : counters.keySet()) {
    editor.putInteger(s, counters.get(s));
}
editor.commit();


//load
SharedPreferences pref = getContext().getSharedPreferences("Your_Shared_Prefs", Context.MODE_PRIVATE);
HashMap<String, Integer> map= (HashMap<String, Integer>) pref.getAll();
for (String s : map.keySet()) {
        Integer value=map.get(s);
        //Use Value
}