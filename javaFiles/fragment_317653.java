Scanner file = new Scanner(new File(textfile));
ArrayList<Word> words = new ArrayList<Word>();
while (file.hasNext()) {

    Word w = new Word(fileWord);

    if (words.contains(w)) {
        words.get(words.indexOf(w)).increaseCount(); // Note the change here.
    } else {
        w.increaseCount(); // This is for the first occurrence as 'count' is 0 initially.
        words.add(w);
    }
}