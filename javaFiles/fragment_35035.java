int x = 0; //Character's x position
int y = 0; //Character's y position
int targetX = 0; //Character's target x position
int targetY = 0; //Character's target y position
int moveSpeed = 2; //the speed at which the character moves
int moveAmt = 20; //amount the character is set to move every time it is told to move

void setTarget(int targetX, int targetY) //sets targetX and targetY, doesn't need to be called at all
{
    this.targetX = targetX;
    this.targetY = targetY;
}

void moveCharacter(int x, int y) //moves the character, doesn't need to be called at all
{
    this.x = x;
    this.y = y;
}

void updatePosition() //initiates/continues movement, should be called every frame
{
    if(Input.equals("up")) {
         setTarget(targetX, targetY - moveAmt);

    } else if(Input.equals("down")) {
         setTarget(targetX, targetX + moveAmt);

    } else if(Input.equals("left")) {
         setTarget(targetX - moveAmt, targetX);

    } else if(Input.equals("right")) {
         setTarget(targetX + moveAmt, targetX);

    }

    if(y > targetY) {
         player.moveCharacter(x, y - moveSpeed);

    } else if(y < targetY) {
         player.moveCharacter(x, y + moveSpeed);

    } else if(x > targetX) {
         player.moveCharacter(x - moveSpeed, y);

    } else if(x < targetX) {
         player.moveCharacter(x + moveSpeed, y);

    }
}