float radius=100;
FloatArray floatArray=new FloatArray();
int accuracy=24;       // can be use 1 for complete circle

for (int angle=0;angle<360;angle += accuracy){
    floatArray.add(radius * MathUtils.cosDeg(angle));
    floatArray.add(radius * MathUtils.sinDeg(angle));
}

Polygon circle=new Polygon(floatArray.toArray()); // This is polygon whose vertices are on circumference of circle

float[] circularPoint=circle.getTransformedVertices();
for (int i=0;i<circularPoint.length;i+=2){
    if(polygon.contains(circularPoint[i],circularPoint[i+1])){
        System.out.println("Collide With circumference");
        break;
    }  
}