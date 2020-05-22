Point p = new Point(0, 0);
Point[] compressedA = {p};  //assuming 'p' is "optimally" stored as {0,0}
Point[] compressedB = {p};  //assuming 'p' is "optimally" stored as {0,0}

compressedA[0].setX(5)  
compressedB[0].setX(1)  

System.out.println(p.x);
System.out.println(compressedA[0].x);
System.out.println(compressedB[0].x);