float[] points = new float[10];
points[0]=(float) 0.3;
points[1]=(float) 0.2;
points[2]=(float) 0.4;
points[3]=(float) 0.5;
points[4]=(float) 0.6;
points[5]=(float) 0.0123;

float[] npoints = Arrays.copyOf(points, points.length);
Arrays.sort(npoints);
System.out.println(Arrays.toString(npoints));
// [0.0, 0.0, 0.0, 0.0, 0.0123, 0.2, 0.3, 0.4, 0.5, 0.6]