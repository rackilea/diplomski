private ArrayList<int[]> randomlyChooseSites() {
    // create a HashSet to hold the sites as two-value int[] arrays.
    ArrayList<int[]> siteList = new ArrayList<>();

    class SiteArea
    {
        boolean is_used; // if false, ignore this area (and the point in it)

        int point_x; // absolute coordinates of point generated in this area
        int point_y;
    }

    int gridsize = (int)Math.ceil (Math.sqrt (AMOUNT_OF_SITES));
    int empty_areas = gridsize * gridsize - AMOUNT_OF_SITES; // we want the empty areas in the corners

    int area_size_x = WIDTH / gridsize;
    int area_size_y = HEIGHT / gridsize;

    SiteArea areas[][] = new SiteArea [gridsize][gridsize];

    // initialize all areas on the grid
    for (int i = 0, imax = gridsize * gridsize; i < imax; i++)
    {
        int x_ = (i % gridsize), x = x_ * area_size_x;
        int y_ = (i / gridsize), y = y_ * area_size_y;

        SiteArea a = areas[x_][y_] = new SiteArea ();
        a.is_used = true; // set all areas as used initially

        // generate the point somewhere within this area
        a.point_x = x + RANDOM.split().nextInt(area_size_x);
        a.point_y = y + RANDOM.split().nextInt(area_size_y);

        // to see the grid, create a drawRect() function that draws an un-filled rectangle on gc, with the other params being: top left corner x, y and rectangle width, height
        //drawRect (gc, x, y, area_size_x, area_size_y);
    }

    // disable some of the areas in case if the grid has more rectangles than AMOUNT_OF_SITES
    // cut away at the four corners, by setting those areas to is_used = false
    class Corner { int x; int y; int xdir; int ydir; Corner (int a,int b,int c,int d) { x=a;y=b;xdir=c;ydir=d; } }
    int z = gridsize-1; Corner corners[] = { new Corner (0,0,1,1), new Corner (z,0,-1,1), new Corner (0,z,1,-1), new Corner (z,z,-1,-1) };
    for (int i = 0, imax = empty_areas; i < imax; i++)
    {
        Corner c = corners[i % 4]; // cycle over the corners
        int x = c.x, y = c.y, offset = (i + 4) / 8, xo = offset, yo = offset;
        if (i % 8 > 3)
        {   // cut x
            xo = 0;
        }
        else
        {   // cut y
            yo = 0;
        }
        areas[x + xo * c.xdir][y + yo * c.ydir].is_used = false;
    }

    // export the generated points to siteList
    for (int i = 0, imax = gridsize * gridsize; i < imax; i++)
    {
        int x_ = (i % gridsize);
        int y_ = (i / gridsize);
        SiteArea a = areas[x_][y_];
        if (a.is_used)
        {
            siteList.add (new int[] { a.point_x, a.point_y });
        }
    }



    return siteList;
}