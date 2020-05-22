List<Integer> weekDays = Arrays.asList(1, 2, 4, 5, 6);
int[] indices = IntStream.rangeClosed(0, weekDays.size())
   .filter(i -> i == 0 || i == weekDays.size() || weekDays.get(i - 1) + 1 != weekDays.get(i))
   .toArray();
int longest = IntStream.range(0, indices.length - 1).map(i -> indices[i + 1] - indices[i])
   .max().orElseThrow(NoSuchElementException::new);
System.out.println(longest);