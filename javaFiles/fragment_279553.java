if (intersection.width >= intersection.height)
{
    ball.setVy(-ball.getVy());
}

if (intersection.height >= intersection.width)
{
    ball.setVx(-ball.getVx());
}