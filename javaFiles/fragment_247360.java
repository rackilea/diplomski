public class SynonymTable {

private Map<Word, Set<Word>> synonymTable = new HashMap<>();

public Set<Word> getSynonyms(Word word) {
    return synonymTable.get(word);
}

public void registerSynonym(Word word, Word... synonymsOfWord) {
    for (Word syn : synonymsOfWord) {
        putSynonymTable(word, syn); // synonym(word) = syn
        putSynonymTable(syn, word); // synonym(syn) = word
    }
}

private void putSynonymTable(Word word, Word synonymOfWord) {
    Set syns = synonymTable.get(word);
    if (syns == null) {
        syns = new TreeSet<Word>();
        synonymTable.put(word, syns);
    }
    syns.add(synonymOfWord);
}
...