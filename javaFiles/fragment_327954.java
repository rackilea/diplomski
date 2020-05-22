float xDirection = FloatMath.sin((float) Math.toRadians(getRotation()))
            * currentSpeed;
float yDirection = FloatMath.cos((float) Math.toRadians(getRotation()))
            * -currentSpeed;

float newX = getX() + xDirection;
float newY = getY() + yDirection;