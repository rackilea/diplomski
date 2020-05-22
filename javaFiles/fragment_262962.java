if (ox > oy )
  return new Vector3f(0,dir.y*oy);//top-bottom collision
else if (ox < oy )
  return new Vector3f(dir.x*ox,0);//left-right collision
else //if(ox == oy)
  return new Vector3f(dir.x*ox,dir.y*oy); //corner-corner collision, 
                                          //unlikely with float's.