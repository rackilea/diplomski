void setup()
{
    size(1000,1000);
    smooth();
    stroke(0);
    frameRate(30);
}

void go(int order, int x1, int y1, float angle, int adder, int length) 
{
    int x2, y2, x3, y3; 
    double newAngle = angle * PI / 180; 

    if (order == 1)
    {
        return;
    }
    else
    {
        x2 = (x1 - round(cos(newAngle) * length));

        y2 = (y1 - round(sin(newAngle) * length));

        line(x1, y1, x2, y2);

        go(order-1, x2, y2, angle+random(20,40), adder+2, 0.618034 * length);
        go(order-1, x2, y2, angle-random(20,40), adder+2, 0.618034 * length);
    }
} 

void draw()
{
    stroke(255, 0, 0);
    strokeWeight(1);

    go(10, 500, 999, 90, 20, 100);
    exit();
}