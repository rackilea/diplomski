/**
     * @param wordsAl : list of words
     */
    public List<String> removeEndWith_at(List<String> wordsAl) {
            wordsAl.removeIf(s -> s.endsWith("at"));
            return wordsAl;
    }