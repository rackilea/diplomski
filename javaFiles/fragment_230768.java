float diffX = mouse.x - player.x;
float diffY = mouse.y - player.y;
float angle = (float) Math.atan2(diffY, diffX);
float velX = (float) (Math.cos(angle));
float velY = (float) (Math.sin(angle));
Vector2 velocity = new Vector2(velX, -velY);
velocity.nor();
velocity.scl(magnitudeSpeed);
velocity.scl(deltaTime);