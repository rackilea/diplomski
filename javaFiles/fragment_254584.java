private void updateObstacles(float dt) {
//nerd == player
    if (obstacle.collides(nerd.getBounds() && !obstacle.isCounted() )) {  //check if obstacle is counted
        switch (obstacle.getType()) {
            ...
            case ConstantsGame.WOMAN_TYPE:
                alreadChanged = false;
                obstacle.setCounted(); //set obstacle as counted 
                Score.updateHeart(gameManager);
            default:
           ...
         }
      }
   }