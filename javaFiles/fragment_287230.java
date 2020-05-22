playerMatrix.postRotate(rotation, bitmap.getWidth()/2, bitmap.getHeight()/2);
playerX += xspeed;
playerY += yspeed;
playerValues[Matrix.MTRANS_X] = playerX;
playerValues[Matrix.MTRANS_Y] = playerY;
playerMatrix.postTranslate(playerX, playerY);