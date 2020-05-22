class Figher{
  // ..
  public void attack(Opponent opponent){
    int opponentMaxDamage = calculateHitpointsBy(opponent);
    int damageByOpponent = opponent.defend(this, opponentMaxDamage);
    this.lifePoints-=damageByOpponent;
  }

  public boolean isAlive(){
    return 0< this.lifePoints;
  }
  // ..
}