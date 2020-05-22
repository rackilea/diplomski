for(int j=0; j<boxes.length;j++) //Runs for the total amount of towers placed
{
  for(int i=0;i<enemy.length; i++) //Runs for the total amount of enemies
  {
    if(enemy[i].getEBox().intersects(boxes[j]))  //boxes[j] is the towers' range box
    {
      enemy[i].setHealth(enemy[i].getHealth()-1);
      break; // skip remaining enemies, since towers has used
             // up it's shooting capability for this round
    }
  }
}