public double[] getSpeed(int sx, int sy, int ex, int ey)
{
    double dx = ex - sx;
    double dy = ey - sy;

    double theta = Math.atan2(dy, dx); //get the angle your bullet will travel

    int bulletSpeed = 5; //how fast your bullet can go.

    double[] speeds = new double[2];

    speeds[0] = Math.cos(theta) * bulletSpeed;
    speeds[1] = Math.sin(theta) * bulletSpeed;

    return speeds;
}