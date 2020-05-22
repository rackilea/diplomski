private void move()
{

for (int z = dots; z > 0; z--)
{
    p1x[z] = p1x[(z - 1)];
    p1y[z] = p1y[(z - 1)];
    p2x[z] = p2x[(z - 1)];
    p2y[z] = p2y[(z - 1)];
}

if (p1LeftDirection)
{
    p1x[0] -= DOT_SIZE;
    if(p1x[0] == p1x[2])
    {
        p1x[0] += 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p1x[0] == p1x[1])
    {
        p1x[0] += DOT_SIZE;
        rotateCorr();
    }
}

if (p1RightDirection)
{
    p1x[0] += DOT_SIZE;
    if(p1x[0] == p1x[2])
    {
        p1x[0] -= 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p1x[0] == p1x[1])
    {
        p1x[0] -= DOT_SIZE;
        rotateCorr();
    }
}

if (p1UpDirection)
{
    p1y[0] -= DOT_SIZE;
    if(p1y[0] == p1y[2])
    {
        p1y[0] += 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p1y[0] == p1y[1])
    {
        p1y[0] += DOT_SIZE;
        rotateCorr();

    }
}

if (p1DownDirection)
{
    p1y[0] += DOT_SIZE;
    if(p1y[0] == p1y[2])
    {
        p1y[0] -= 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p1y[0] == p1y[1])
    {
        p1y[0] -= DOT_SIZE;
        rotateCorr();
    }
}

if (p2LeftDirection)
{
    p2x[0] -= DOT_SIZE;
    if(p2x[0] == p2x[2])
    {
        p2x[0] += 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p2x[0] == p2x[1])
    {
        p2x[0] += DOT_SIZE;
        rotateCorr();
    }
}

if (p2RightDirection)
{
    p2x[0] += DOT_SIZE;
    if(p2x[0] == p2x[2])
    {
        p2x[0] -= 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p2x[0] == p2x[1])
    {
        p2x[0] -= DOT_SIZE;
        rotateCorr();
    }
}

if (p2UpDirection)
{
    p2y[0] -= DOT_SIZE;
    if(p2y[0] == p2y[2])
    {
        p2y[0] += 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p2y[0] == p2y[1])
    {
        p2y[0] += DOT_SIZE;
        rotateCorr();
    }
}

if (p2DownDirection)
{
    p2y[0] += DOT_SIZE;
    if(p2y[0] == p2y[2])
    {
        p2y[0] -= 2*DOT_SIZE;
        rotateCorr();
    }
    else if(p2y[0] == p2y[1])
    {
        p2y[0] -= DOT_SIZE;
        rotateCorr();
    }
}
dots++;
}