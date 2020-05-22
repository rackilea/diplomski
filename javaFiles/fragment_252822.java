class Highscore {

    private String username;
    public int score;

    //getters setters constructors

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Highscore highscore = (Highscore) o;
        return score == highscore.score &&
                Objects.equals(username, highscore.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, score);
    }
}