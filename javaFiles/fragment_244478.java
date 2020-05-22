public void slow()
{
    double len = Math.sqrt(xVel*xVel + yVel*yVel);
    double sx = xVel/len*0.02;
    double sy = yVel/len*0.02;
    xVel = xVel - sx;
    yVel = yVel - sy;
}