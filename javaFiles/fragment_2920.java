List<Rules> rules = new ArrayList<rules>();

List<String> snippets = new ArrayList<String>();
// Add all illegal substrings to a dictionary
for (i = 0; i < username.length() - 4; i++) {
    snippets.add(username.substring(i, i + 4)); 
}
Dictionary dict = new WordListDictionary(new ArrayWordList(snippets.toArray(new String[snippets.size()]));
Rule dsr = new DictionarySubstringRule(dict);
rules.add(dsr);