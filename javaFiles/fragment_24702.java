double calculateDistance(double[] point1, double[] point2)
{
x1 = point1[0]; // Or you can use enum or something for the index
y1 = point1[1];
z1 = point1[2];

x2 = point2[0];
y2 = point2[1];
z2 = point2[2];

return Math.sqrt ( Math.pow (( x2 - x1 ), 2 ) 
                                + Math.pow (( y2 - y1 ), 2 )
                                + Math.pow (( z2 - z1 ), 2 ));
}