long start = System.currentTimeMillis();
ArrayList<Integer> list = new ArrayList<>();
for (int i = 0; i < 1000000; i++)
    list.add(i);
int sum = 0;
for (int num : list)
    sum += num;
long end = System.currentTimeMillis();
System.out.printf("Sum of %d values is %d%n", list.size(), sum);
System.out.printf("Built and calculated in %.3f seconds%n", (end - start) / 1000.0);