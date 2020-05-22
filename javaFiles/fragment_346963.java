private void keepScore(boolean isHit) {
    if(isHit) {
        for (int i = 0; i < lettersHit.length(); i++) {
            score += MAX_SCORE_POINTS;
        }
    } else {
        for (int i = 0; i < lettersMissed.length(); i++ ) {
            score -= MAX_SCORE_POINTS;
        }
    }
}