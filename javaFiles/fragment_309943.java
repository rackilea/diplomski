public void update(GameContainer container, int delta)
{
    playerUpdate(delta);

    player.rect.setLocation(playX, playY);
    enemy.rect.setLocation(enemyX, enemyY); // update the hitboxes to the new positions

    if (player.rect.intersects(enemy.rect))
    {
        System.out.println("INTERSECT!");
    }
}

public void playerUpdate(int delta)
{
    if (playerForward == true)
    {
       playX -= delta * 0.4f;

       if (playX <= 140) 
       {
             playX = 140;
             playerForward = false;
             playerBackward = true;
       }
    }

    if (playerBackward == true) 
    {
         playX += delta * 0.4f;

         if (playX >= 700) 
         {
             playX = 700;
             playerBackward = false;
             delay = 1250;
         }
    }
}

public void keyReleased(int key, char c) 
{
   if (key == Input.KEY_ENTER)
   {
      playerForward = true;
   }
}