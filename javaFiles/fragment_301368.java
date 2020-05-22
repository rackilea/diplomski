int numOfCircles=40;
float rad=10;
List<Point> points=new ArrayList<Point>();
for(float a=0;a<360;a+=(360/numOfCircles)){
    points.add(new Point(Math.cos((a) * 0.0174532925f) * rad), Math.sin((a) * 0.0174532925f) * rad));
}