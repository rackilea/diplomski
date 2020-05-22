if (diction.remove(word)) {
    obsolete.add(new WordMeaning(word, " "));
    // notify about deletion
} else {
    // notify that word don't exist.
}