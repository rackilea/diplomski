int deltaY = y2 - y1;
int deltaX = x2 - x1;

if (deltaY == 0)
{
    System.out.println("The slope is 0, no linear line.");
}else if (deltaX == 0)
{
    System.out.println("Not a Linear Line");
}else
{
    double RC = (double) deltaY / deltaX;
    System.out.println("The slope is: " + RC);
    double B = y1-(RC*x1);
    System.out.println("The crosspoint with Y, if x is 0, : " + B);
}