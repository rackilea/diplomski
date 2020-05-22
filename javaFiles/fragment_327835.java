AutoSuggestor autoSuggestor = new AutoSuggestor(textCompanyName, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
    @Override
    boolean wordTyped(String typedWord) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("heritage");
        words.add("happiness");
        words.add("goodbye");
        words.add("cruel");
        words.add("car");
        words.add("war");
        words.add("will");
        words.add("world");
        words.add("wall");
        return super.wordTyped(typedWord);
    }
};