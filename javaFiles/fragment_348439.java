int size = 20;
double[] array = new double[size];
Random rand = new Random();
for (int i = 0; i < size; i++)
    array[i] = rand.nextInt(10_000 * 10) / 10.0;
System.out.println(Arrays.toString(array));