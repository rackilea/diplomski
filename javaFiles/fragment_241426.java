// Two rectangles, assume the class name is `Rect`
Rect r1 = new Rect(x1, y2, w1, h1);
Rect r2 = new Rect(x3, y4, w2, h2);

// get the coordinates of other points needed later:
int x2 = x1 + w1;
int x4 = x3 + w2;
int y1 = y2 - h1;
int y3 = y4 - h2;

// find intersection:
int xL = Math.max(x1, x3);
int xR = Math.min(x2, x4);
if (xR <= xL)
    return null;
else {
    int yT = Math.max(y1, y3);
    int yB = Math.min(y2, y4);
    if (yB <= yT)
        return null;
    else
        return new Rect(xL, yB, xR-xL, yB-yT);
}