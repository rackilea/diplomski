//start at top-left
int x = center_x - (len/2);
int y = center_y - (len/2);

//point to the right
int dx=1;
int dy=0;

for (int side=0; side<4; ++side) {
    for (int i=1; i<len; ++i) {
        do_something(x,y);
        x+=dx;
        y+=dy;
    }
    //turn right
    int t=dx;
    dx=-dy;
    dy=t;
}