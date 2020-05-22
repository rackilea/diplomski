//Values
final static double[] r1Points = {2.828427125, 0}; //Equivilant 2√2
final static double[] r3Points = {0, 35.35533906}; //Equivilant 25√2
final static int[] widthNHeight = {50, 4}; //Width then height
final static double angle = 45.0; //Angle to rotate lines

//Declaring the rectangles
Rectangle2D r1 = new Rectangle2D.Double(r1Points[0], r1Points[1], widthNHeight[0], widthNHeight[1]);
Rectangle2D r3 = new Rectangle2D.Double(r3Points[0], r3Points[1], widthNHeight[0], widthNHeight[1]);

//r1
g2d.rotate(Math.toRadians(angle), r1Points[0], r1Points[1]); //Rotates graphic for first rectangle
g2d.fill(r1);

//r3
g2d.rotate(Math.toRadians(-angle), r1Points[0], r1Points[1]); //Rotates the graphic back to straight
g2d.rotate(Math.toRadians(-angle), r3Points[0], r3Points[1]); //Rotates graphic for second rectangle
g2d.fill(r3);