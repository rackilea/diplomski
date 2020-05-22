float getRadialX(float x,float y,float cx,float cy,float k){
  x = (x*xscale+xshift);
  y = (y*yscale+yshift);
  float res = x+((x-cx)*k*((x-cx)*(x-cx)+(y-cy)*(y-cy)));
  return res;
}

float getRadialY(float x,float y,float cx,float cy,float k){
  x = (x*xscale+xshift);
  y = (y*yscale+yshift);
  float res = y+((y-cy)*k*((x-cx)*(x-cx)+(y-cy)*(y-cy)));
  return res;
}