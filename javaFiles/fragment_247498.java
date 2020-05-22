public static void main(String args[])
{
    int min = -100;
    int max = 100;

    int[] array = new int[201];
    for (int i = 0; i < array.length; i++) {
        array[i] = min + (int) (Math.random() * ((max - min) + 1));
    }

    List<Double> result1 = new ArrayList<>();
    for (int j = 2; j < array.length; j += 3) {
        result1.add(Math.sqrt(Math.abs(array[j])));
    }

    double[] result2 = new double[array.length / 3];
    for (int j = 2; j < array.length; j += 3) {
        result2[j / 3] = Math.sqrt(Math.abs(array[j]));
    }

    System.out.println(result1);
    System.out.println(Arrays.toString(result2));
}