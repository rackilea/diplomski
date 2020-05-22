class ParamsGeneral {
    public int getMaxScore() {
        return 1000;
    }
}
class ParamsLimited extends ParamsGeneral {
    @Override public int getMaxScore() {
        return 500;
    }
}

...

public boolean isWinner() {
    // You do not need an "if" statement, because
    // the == operator already gives you a boolean:
    return this.score == par.getMaxScore();
}