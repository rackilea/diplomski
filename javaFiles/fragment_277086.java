final float deltaX = touchEvent.getX() - player.x; // player.x is point1.x
final float deltaY = touchEvent.getY() - player.y; // player.y is point1.y
final float length = Maths.sqrt((deltaX)^2 + (deltaY)^2);
final float itterations = length / getSpeed();
final float velX = deltaX / itterations;
final float velY = deltaY / itterations;
player.move(velX, velY);