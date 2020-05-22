for (y=0;y<height;y++)
 {
 r0=0; g0=0; b0=0;
 for (x=0;x<width;x++)
  {
  // pick and add wanted color
  col=pixel(x,y);
  r0+=col.r;
  g0+=col.g;
  b0+=col.b;
  // chose closest color
  ix=0; col=(r0,g0,b0);
  for (i=0;i<palette_size;i++)
   if (color_distance(col,pal[i])<color_distance(col,pal[ix]))
    ix=i;
  col=pal[ix];
  // render and substract chosed color
  pixel(x,y)=col;
  r0-=col.r;
  g0-=col.g;
  b0-=col.b;
  }
 }