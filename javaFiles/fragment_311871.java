public void calculateScore()
  {
    newScore = previousScore + SCORE_PER_CYCLE_ADDED;
    // then you add in the scores from 'whatever' they did in that cycle
    // such as killing enemies
    for(Enemy defeatedEnemy: EnemiesDefeatedThisCycle){
          newScore += defeatedEnemy.getScoreValue();
    }
    // collected points items
    for(Item itemCollected: CollectedItemsThisCycle){
          newScore += itemCollected.getScoreValue();
    }
}