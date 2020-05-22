Path polyPath = new Path();
int minX,minY,maxX,maxY; 
for( Point current : pointsList ){
polypath.lineTo(current.x, current.y); 
//TO DO : also add calculation for minX,minY,maxX,maxY here // 
}
polyPath.lineTo(pointsList.get(0).x, pointsList.get(0).y);
polyPath.close();