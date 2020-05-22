int minx=Integer.MAX_VALUE;
int maxx=-1;
int miny=Integer.MAX_VALUE;
int maxy=-1;
int count=0;
for x=0...
  for y=0...
    if(1==a[x][y]{
      minx=Math.min(minx,x);
      maxx=Math.max(maxx,x);
      miny=Math.min(miny,y);
      maxy=Math.max(maxy,y);
      count ++;
    }

return count==(maxx-minx+1)*(maxy-miny+1);