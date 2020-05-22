int clamp(int x, int min, int max)
{
    if (x < min) return min;
    if (x > max) return max;
    return x;
}

int wrap(int x, int min, int max)
{
    while (x<min)
       x += (1+max-min);

    while (x>max)
       x -= (1+max-min);

    return x;
}


for every pixel (x,y) in the buffer

    Xoffset = buffer(x-1, y) - buffer(x+1, y)
    Yoffset = buffer(x, y-1) - buffer(x, y+1)

    Shading = Xoffset

    Xoffset >>= 1                              // Halve the amount of refraction
    Yoffset >>= 1                              // if you want.

    Xcoordinate = clamp(x+Xoffset, 0, Xmax)    // Use clamp() or wrap() here
    Ycoordinate = clamp(y+Yoffset, 0, Ymax)    // 
    t = texture(Xcoordinate, Ycoordinate)  

    p = t + Shading

    plot pixel at (x,y) with colour p

end loop