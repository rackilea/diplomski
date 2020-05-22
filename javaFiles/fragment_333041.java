for (Tank tank : tanks) {
   if (station.getRectangle().intersects(tank.getRectangle())) {
     station.kill();
     i=i-1;
     break;
   }
 }