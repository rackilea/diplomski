public enum ScopeItems {

    BASIC_INFO(1), POLICY_INFO(2), USER_INFO(4);

    private final int score;
    public int getScore() {
        return score;
    }
    private ScopeItems(int score) {
        this.score = score;
    }

    public static Set<ScopeItems> getScopeByScore(int score) {
        return Stream.of(values()).filter(i -> (i.getScore() | score) == score).collect(Collectors.toSet());
    }

    public static int getScoreByItems(Set<ScopeItems> items) {
        return items.stream().mapToInt(i -> i.getScore()).sum();
    }

};