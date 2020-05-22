String knownLanguages ="German,Urdu,Arabic";
// get a list of languages from above string using String#split
List<String> langList = Arrays.asList(knownLanguages.split(","));
// sort the resulting list
Collections.sort(langList);
// print it
System.out.println(langList);
// OUTPUT: [Arabic, German, Urdu]