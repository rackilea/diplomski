// create and draw triangles
// use a Path object to store the 3 line segments
// use .offset to draw in many locations
// note: this triangle is not centered at 0,0
paint.setStyle(Paint.Style.STROKE);
paint.setStrokeWidth(2);
paint.setColor(Color.RED);
Path path = new Path();
path.moveTo(0, -10);
path.lineTo(5, 0);
path.lineTo(-5, 0);
path.close();
path.offset(10, 40);
canvas.drawPath(path, paint);
path.offset(50, 100);
canvas.drawPath(path, paint);
// offset is cumlative
// next draw displaces 50,100 from previous
path.offset(50, 100);
canvas.drawPath(path, paint);