private boolean checkAnswers(boolean[] responses) {
    for (boolean b : responses) {
        if (!b) return false
    }
    return true;
}