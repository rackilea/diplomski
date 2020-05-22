private static void populateBoard(int[] xs, int[] ys, int w, int h)
{
    Set<Point> points = new HashSet<>();
    for(int i=0;i<xs.length;i++)
    {
        int x = xs[i];
        int y = ys[i];
        points.add(new Point(x,y));
    }
    for(int i=0;i<h;i++)
    {
        for(int j=0;j<w;j++)
        {
            Point p = new Point(j,i);
            if(points.contains(p))
                System.out.print("■");
            else
                System.out.print(".");
        }
        System.out.print("\n");
    }
}