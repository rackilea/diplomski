GPen black = new GPen(); //Make new pen

 int[] x_coords = new int[4] {0,-40,0,40};
 int[] y_coords = new int[4] {30,0,-30,0};

 add(black, 270, 30); //Add it at these coords

 for (int i=0; i<x_coords.length; i++){
    black.drawLine( -1*x_coords[i] , y_coords[i]);
 }