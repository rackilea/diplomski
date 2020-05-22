int[] primitiveInts = {1, 2, 3};
Integer[] wrappedInts = Arrays.stream(primitiveInts)
                              .boxed()
                              .toArray(Integer[]::new);
int[] unwrappedInts = Arrays.stream(wrappedInts)
                             .mapToInt(Integer::intValue)
                             .toArray();
assertArrayEquals(primitiveInts, unwrappedInts);

double[] primitiveDoubles = {1.1d, 2.2d, 3.3d};
Double[] wrappedDoubles = Arrays.stream(primitiveDoubles)
                                .boxed()
                                .toArray(Double[]::new);
double[] unwrappedDoubles = Arrays.stream(wrappedDoubles)
                                  .mapToDouble(Double::doubleValue)
                                  .toArray();

assertArrayEquals(primitiveDoubles, unwrappedDoubles, 0.0001d);