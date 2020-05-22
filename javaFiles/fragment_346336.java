float scaleX = (float)width/boundingPoints.width;
    float scaleY = (float)height/boundingPoints.height;
    int bx = boundingPoints.x;
    int by = boundingPoints.y;
    for(int i = 0; i < cg_points.size()-1; i++){
            Point p1 = cg_points.get(i);
            Point p2 = cg_points.get(i+1);
            int x1 = (int) ((p1.x-bx)*scaleX);
            x1 += pos.x;
            int y1 = (int) ((p1.y-by)*scaleY);
            y1 += pos.y;
            int x2 = (int) ((p2.x-bx)*scaleX);
            x2 += pos.x;
            int y2 = (int) ((p2.y-by)*scaleY);
            y2 += pos.y;

            g.drawLine(x1, y1, x2, y2);
        }