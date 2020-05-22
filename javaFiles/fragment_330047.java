public static void main(String... args) throws Throwable {
  ArrayList<Integer> ints = new ArrayList<>();
  for(int i=0;i<100;i++) ints.add(i);
  sumSize(ints, 5000);
  castSumSize(ints, 5000);
  sumSize(ints, 5000);
  castSumSize(ints, 5000);
}

public static long sumSize(ArrayList<Integer> ints, int runs) {
  long sum = 0;
  long start = System.nanoTime();
  for(int i=0;i<runs;i++)
    sum += ints.size();
  long time = System.nanoTime() - start;
  System.out.printf("sumSize: Took an average of %,d ns%n", time/runs);
  return sum;
}

public static long castSumSize(ArrayList<Integer> ints, int runs) {
  long sum = 0;
  long start = System.nanoTime();
  for(int i=0;i<runs;i++)
    sum += ((Collection) ints).size();
  long time = System.nanoTime() - start;
  System.out.printf("castSumSize: Took an average of %,d ns%n", time/runs);
  return sum;
}