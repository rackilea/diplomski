playerAngle = player.body.getAngle()*MathUtils.radiansToDegrees;

while(playerAngle<=0){
        playerAngle += 360;
    }
while(playerAngle>360){
        playerAngle -= 360;
    }