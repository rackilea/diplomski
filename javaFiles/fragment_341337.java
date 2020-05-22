class Point {
    double x;
    double y;
}


Point[] line = new Point[6];
for(int i = 0; i < line.length; i++) {
    line[i] = new Point();
}

    // now you can set the values, since the point's aren't null
line[0].x = 10;
line[0].y = 10;