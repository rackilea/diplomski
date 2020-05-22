for (int i = 0; i < balls.length; i++)
{
    for (int j = 0; j < balls.length; j++)
    {
        // Check first that you are not comparing a ball to itself.
        if (i != j)
            if (balls[i].intersect(balls[j]))
                balls[i].moveIntersectingBalls();
    }
}