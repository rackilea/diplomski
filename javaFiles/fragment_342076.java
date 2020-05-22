// to create an empty dictionary
HashMap<String, List<String>> dictionaryMap = new HashMap<String, List<String>>();

// to add the word "exampleWord", with meaning "exampleMeaning"
if ( !dictionaryMap.containsKey("exampleWord")) {
    dictionaryMap.put("exampleWord",new ArrayList<String>());
}
dictionaryMap.get("exampleWord").add("exampleMeaning");