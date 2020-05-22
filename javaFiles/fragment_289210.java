public static class ScoredEntry {
    private SomeGameData data; //or something
    private int score;
    // constructor takes data + score,  imagine getters, setters, I am lazy ok.
}

public List<ScoredEntry> scoreEntries(List<SomeGameData> gameData) {
    List<ScoredEntry> result = new ArrayList<ScoredEntry>();
    for (SomeGameData data : gameData) {
        int score = calculateScore(data);
        result.add(new SCoredEntry(score, data);
    }
    return result;
}

public void sortBySCore(List<ScoredEntry> list) {
    Collections.sort(list, new Comparator<ScoredEntry>() {
        public int compare(SCoredEntry a, ScoredEntry b) {
            // etcetera.
        }
    }
}