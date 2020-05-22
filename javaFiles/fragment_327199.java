Obstacle[] myObstacles = new Obstacle[30];
Player player = new Player();
....
for (Obstacle obstacle : myObstacles) {
  obstacle.paint(g);
}
player.paint(g);