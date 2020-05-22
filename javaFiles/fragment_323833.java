class Player {

private String name;

private int score;

public Player(String name, int score) {
    this.name = name;
    this.score = score;
}

public String getName() {
    return name;
}

public int getScore() {
    return score;
}

public String toString() {
    return "name=" + name + "; score=" + score;
}