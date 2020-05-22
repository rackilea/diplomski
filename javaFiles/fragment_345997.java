boolean airborne = false;

while (true) // the main game loop
{
    if (y <= 48 && airborne) // if player just hit the ground
    {
        //  Perform the "bounce" by changing their vertical direction and decreasing its magnitude
        ySpeed = -ySpeed/2.0;

        //  This will stop them from bouncing infinitely.  After the bounce gets too small,
        //  they will finally land on the ground.  I suggest you play around with this number to find one that works well
        if (Math.abs(ySpeed) <= 0.5)
        {
            //  Stop the bouncing
            ySpeed = 0;

            //  Place them on the ground
            airborne = false;
            y = 48;
        }
    }
    //  Apply friction if they are on the ground
    if (!airborne)
    {
        // Friction on ground
        if ((!Keyboard.isKeyDown(Keyboard.KEY_LEFT)) && xspeed < 0) xspeed = xspeed * 0.925;
        if ((!Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) && xspeed > 0) xspeed = xspeed * 0.925;
    }
    //  Apply a jump action if they're pressing the jump button while on the ground
    if (Keyboard.isKeyDown(Keyboard.KEY_UP) && !airborne) 
    {
        airborne = true;
        yspeed = 10;
    }
}