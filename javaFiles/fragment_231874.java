int x = xmin;
int last_y = 300-(x*x);
for (x = xmin+1; x<=xmax; x++);
    y = 300-(x*x);
    l.drawLine(x-1, last_y, x, y);
    last_y = y;
}