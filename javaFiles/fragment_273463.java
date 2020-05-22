int max = 10;
List<Integer> shuffled = new ArrayList<>(max);
for (int i = 0; i < max; ++i) {
    shuffled.add(i);
}
Collections.shuffle(shuffled);
System.out.println(shuffled);