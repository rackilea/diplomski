class Opponent{
  // ..
  public void defend(Figher fighter, int maxAttackDamage){
    int myDamage = reduceDamage(fighter,int maxAttackDamage);
    int attackerDamage = calculateAttackerDamage(fighter);
    this.lifePoints-=myDamage ;
  }

  public boolean isAlive(){
    return 0< this.lifePoints;
  }
  // ..
}