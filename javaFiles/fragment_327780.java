//Initialize these however you want to
int x1;
int x2;
int x3;
int y1;
int y2;
int y3;

//Bounding rectangle
int minX = min(x1, x2, x3)
int maxX = max(x1, x2, x3)
int minY = min(y1, y2, y3)
int maxY = max(y1, y2, y3)

for(int x = minX; x <= maxX; x++)
{
    for(int y = minY; y <= maxY; y++)
    {
        //If point in triangle
        if((x1 - x2) * (y - y1) - (y1 - y2) * (x - x1) > 0 &&
           (x2 - x3) * (y - y2) - (y2 - y3) * (x - x2) > 0 &&
           (x3 - x1) * (y - y3) - (y3 - y1) * (x - x3) > 0)
        {
            //Color pixel
        }
    }
}