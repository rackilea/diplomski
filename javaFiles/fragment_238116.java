Point[] points = sort(input());
int[] closest = new int[points.length];

for (int i = 0; i < points.length; i++)
{
    double bestdist = Double.POSITIVE_INFINITY;

    for (int j = i + 1; (j < points.length) && ((points[j].x - points[i].x) < bestdist); j++ )
    {
        double currdist = dist(points[i], points[j]);

        if (currdist < bestdist)
        {
            closest[i] = j;
            bestdist = currdist;
        }
    }
    for (int j = i - 1; (j >= 0) && ((points[i].x - points[j].x) < bestdist); j-- )
    {
        double currdist = dist(points[i], points[j]);

        if (currdist < bestdist)
        {
            closest[i] = j;
            bestdist = currdist;
        }
    }
}