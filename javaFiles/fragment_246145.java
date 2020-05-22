List<Point> points = new ArrayList<Point>();

Point pointOne = new Point(x,y);
Point pointTwo = new Point(x+25,y);
Point pointThree = new Point(x+25,y+5);
Point pointFour = new Point(x,y+5);
points.add(pointOne );
points.add(pointTwo );
points.add(pointThree );
points.add(pointFour);



Path path = new Path();
path.moveTo(pointOne.x, pointOne.y);
path.lineTo(pointTwo.x, pointTwo.y);
//and so on
path.close();

//and then
pList.add(points);