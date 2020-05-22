NavigableSet<Integer> nums = new TreeSet<>();
System.out.println("Input 6 numbers: ");
for (int i = 0; i < 6; i++) {
    nums.add(Integer.valueOf(br.readLine()));
}

Integer[] sortedNums = nums.descendingSet().toArray(new Integer[6]);