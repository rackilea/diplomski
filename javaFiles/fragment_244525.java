Point[] temp = new Point[mypointarray.length];
for (int i = temp.length - 1; i >= 0; --i) {
    Point p = mypointarray[i];
    if (p != null) {
        temp[i] = new Point(p);
    }
}