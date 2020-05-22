while (file.hasNext()) {

    Word w = new Word(fileWord);

    if (words.contains(w)) {
        w.increaseCount(); // Here's what goes wrong.
    } else {
        words.add(w);
    }
}