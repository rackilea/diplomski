float speed,angle;

Vector2 startingVelocity =new Vector2(speed,speed);
startingVelocity.rotate((float) angle - 45);

body.setLinearVelocity(startingVelocity);