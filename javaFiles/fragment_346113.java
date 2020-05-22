public void Attack(Hero attacker, Hero defender)
{
    //decrease the defender's HP by the attacker's attack
    defender.reduceHP(attacker.getAttack());

    //Print out names and damaged caused
    System.out.println(attacker.getName() + " has attacked " + defender.getName() + " causing " + attacker.getAttack());


    System.out.println(defender.getName() + " now has " + defender.getHP());
}