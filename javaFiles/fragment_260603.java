// please do NOT name classes with lower case...
example e = new example();
e.addRectangle(0, 0);
e.addRectangle(100, 100);

Rectangle rect1 = e.getRectangle(0);
System.out.println("Rectangle 1: ["+rect1.getX()+", "+rect1.getY()+"]");
Rectangle rect2 = e.getRectangle(1);
System.out.println("Rectangle 2: ["+rect2.getX()+", "+rect2.getY()+"]");

// but:
System.out.println("Rectangle 1: ["+rect1.getX()+", "+rect1.getY()+"]");
// oops.

System.out.println("Rectangle 1 and 2 are the same: " + (rect1==rect2) );