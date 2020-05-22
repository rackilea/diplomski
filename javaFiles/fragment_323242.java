public static void sortByX(List<? extends Point> points)
{
    Collections.sort(points, 
        new Comparator<Point>() //); - remove these
        {
            public int compare(Point point1, Point point2)
            {
                if (point1.x < point2.x)
                    return -1;
                if (point1.x > point2.x)
                    return 1;
                return 0;
            }
        }); // add ); here
}