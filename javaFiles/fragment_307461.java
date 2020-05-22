if(tileRect[w].intersects(getRect())) {
     System.out.println("intersecting");
     dy = 0;
     break;
 } else if (!tileRect[w].intersects(getRect())){
     dy = 4;
 }