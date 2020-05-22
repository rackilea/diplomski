Scanner scanner = new Scanner(System.in);
double[] randomIntervals = new double[5];
for (int i = 0; i < 5; i++) {
  long start = System.currentTimeMillis();
  scanner.nextLine();
  long end = System.currentTimeMillis();
  randomIntervals[i] = end - start;
}
System.out.println(Arrays.toString(randomIntervals));
scanner.close();