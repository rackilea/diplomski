String[] keys = { "one", "two", "three" };
int[] intValues = { 1, 2, 3 };
float[] floatValues = { 1.1f, 2.2f, 3.3f };

Integer[] integers = box(intValues);
Map<String, Integer> map = toMap(keys, integers, HashMap::new);
System.out.println(map); // {one=1, three=3, two=2}

Float[] floats = box(floatValues);
Map<String, Float> map2 = toMap(keys, floats, LinkedHashMap::new);
System.out.println(map2); // {one=1.1, two=2.2, three=3.3}

Pair<String[], Integer[]> arrays = toArrays(map, String[]::new, Integer[]::new);
System.out.println(Arrays.toString(arrays.a)); // [one, three, two]
int[] unboxedInts = unbox(arrays.b);
System.out.println(Arrays.toString(unboxedInts)); // [1, 3, 2]

Pair<String[], Float[]> arrays2 = toArrays(map2, String[]::new, Float[]::new);
System.out.println(Arrays.toString(arrays2.a)); // [one, two, three]
float[] unboxedFloats = unbox(arrays2.b);
System.out.println(Arrays.toString(unboxedFloats)); // [1.1, 2.2, 3.3]