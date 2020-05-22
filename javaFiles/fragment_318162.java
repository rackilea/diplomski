public int DFS(int x, int y){
    int num = 1;
    Point p = new Point(x, y); //fix
    int color = this.getColor(p);
    Checkers h = new Checkers(color,p);

    // this is good, but you've creating the object in the DFS, meaning when 
    // you revisit it, you don't know you've been here. You need a 
    // class variable representing each part in the grid.
    h.setVisited();

    for(int dx=-1; dx<=1; dx++){
        for(int dy=-1; dy<=1; dy++){
            Point u = new Point(x+dx, y+dy);

            // need to test h.isVisited();
            if (this.getColor(u)==color){ 
                num = num + DFS(x+dx, y+dy);
            }
        }
    }
    return num;
}