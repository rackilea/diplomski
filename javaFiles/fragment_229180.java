screenWidth = gc.getWidth();
screenHeight = gc.getHeight();

cameraX = (screenWidth / 2) - (playerX / 2);
cameraY = (screenHeight / 2) - (playerY / 2);

map.render(playerX, playerY);
player.draw(cameraX, cameraY);