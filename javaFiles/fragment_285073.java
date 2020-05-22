ball.x += speedX;
if (intersects(ball, brick))
{
    //Ball touched brick on left/right side (depending if speedX is positive or negative)
}
ball.y += speedY;
if (intersects(ball, brick))
{
    //Ball touched brick on top/bottom side (depending if speedY is positive or negative)
}