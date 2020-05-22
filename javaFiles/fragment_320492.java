public static boolean intersects(Path2D.Double path, Line2D line) {
    double x1 = -1 ,y1 = -1 , x2= -1, y2 = -1;
    for (PathIterator pi = path.getPathIterator(null); !pi.isDone(); pi.next()) 
    {
        double[] coordinates = new double[6];
        switch (pi.currentSegment(coordinates))
        {
        case PathIterator.SEG_MOVETO:
        case PathIterator.SEG_LINETO:
        {
            if(x1 == -1 && y1 == -1 )
            {
                x1= coordinates[0];
                y1= coordinates[1];
                break;
            }               
            if(x2 == -1 && y2 == -1)
            {
                x2= coordinates[0];             
                y2= coordinates[1];
                break;
            }
            break;
        }
        }
        if(x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1)
        {
            Line2D segment = new Line2D.Double(x1, y1, x2, y2);
            if (segment.intersectsLine(line)) 
            {
                return true;
            }
            x1 = -1;
            y1 = -1;
            x2 = -1;
            y2 = -1;
        }
    }
    return false;
}