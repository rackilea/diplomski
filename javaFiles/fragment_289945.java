private void setBestScore(int bestScore) {
    SharedPreferences.Editor editor = getContext().getSharedPreferences("gamepanel", MODE_PRIVATE).edit();
    editor.putInt("bestScore", bestScore);
    editor.apply();
}

private int getBestScore() {
    SharedPreferences prefs = getContext().getSharedPreferences("gamepanel", MODE_PRIVATE);
    return prefs.getInt("bestScore", 0);
}