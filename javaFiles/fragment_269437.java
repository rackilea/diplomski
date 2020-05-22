void spiral_triangle(float len, int startx, int starty, float angle){
   if (len>1) {
      float new_len = len - 0.1;
      float new_angle = angle + PI/100;
      int oldx = int(startx+len*cos(angle));
      int oldy = int(starty+len*sin(angle));
      int newx = int(startx+new_len*cos(new_angle));
      int newy = int(starty+new_len*sin(new_angle));
      line( oldx,oldy,newx,newy);   
      spiral_triangle(new_len, startx,starty,new_angle);
   } 
}