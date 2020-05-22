// the same as contains.
Pattern p = Pattern.compile("preference_network_");
p.matcher(str).find(); 

// the same as startsWith.
Pattern p = Pattern.compile("^preference_network_");
p.matcher(str).find();