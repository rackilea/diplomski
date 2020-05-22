for (int j=0; j<boxes.length; j++) //Runs for the total amount of towers placed
{
   int enemyToShootIdx = -1;
   for (int i=0; i<enemy.length; i++) //Runs for the total amount of enemies
      if (enemy[i].getEBox().intersects(boxes[j]))  //boxes[j] is the towers' range box
         if (enemyToShootIdx == -1 || betterCandidate(boxes[j], enemy[i], enemy[enemyToShootIdx]))
            enemyToShootIdx = i;
   if (enemyToShootIdx != -1)
      enemy[enemyToShootIdx].setHealth(enemy[enemyToShootIdx].getHealth()-1);
}