// Get the current list.
SharedPreferences sp = getSharedPreferences("passes", 0);
SharedPreferences.Editor editor = getSharedPreferences("passes", 0).edit();
Set<String> passes = sp.getStringSet("myStrings", new HashSet<String>());

//Make a copy, update it and save it
Set<String> newPasses = new HashSet<String>();
newPasses.add(pass);
newPasses.addAll(passes);
editor.putStringSet("myStrings", newPasses); editor.commit();