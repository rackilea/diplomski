Set<String> pathNamesImage = new HashSet<String>();

// Initialize a string array to hold all your set entries
String[] stringArray= new String[pathNamesImage.size()];

// Now, you can iterate over Set, by using the array
for(String str : pathNamesImage.toArray(stringArray)){
    Log.d("yeah", "str:" + str);        
}