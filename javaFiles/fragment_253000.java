private void fight()
{
    //I'm using a rand.nextInt() to get enemychoice
    Enemies enemy = new Enemies(enemyChoice);
    System.out.println("You run into a "  + enemy.enemyName);
}