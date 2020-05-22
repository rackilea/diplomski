Polygon polygon=new Polygon();
polygon.setVertices(new float[]{0,0,.......});
Circle circle=new Circle(x, y, radius);

float points[]=polygon.getTransformedVertices();

for (int i=0;i<points.length;i+=2){
    if(circle.contains(points[i],points[i+1])){
        System.out.println("Collide");
    }
}