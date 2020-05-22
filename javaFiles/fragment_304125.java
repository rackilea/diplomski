double[] array=new double[]{1,2,3};
List<double[]> list=Arrays.asList(array); // Here T is `double[]` List of size 1

...

double[][] array = new double[][] { { 1, 2, 3 }, { 4, 5, 6 } };
List<double[]> list=Arrays.asList(array); // Here T is `double[]` List of size 2

...

List<Double> list=Arrays.asList(1.0,2.0,3.0); // Here T is double List of size 3