public static class MazeWall{
    public static final int OpeningWidth = 10;

    Point start;
    Point end;
    Point opening;

    public MazeWall(Point start, Point end, boolean hasOpening){
        this.start = start;
        this.end = end;

        if(hasOpening){
            int range;
            if(start.x == end.x){
                range = end.x - start.x - OpeningWidth;
                int location = (int)(Math.random() * range + start.x);
                opening = new Point(location, start.y);
            } else{
                range = end.y - start.y - OpeningWidth;
                int location = (int)(Math.random() * range + start.y);
                opening = new Point(location, start.x);
            }
        }   
    }
}