Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
int target = 7;

Set<Integer> used = new HashSet<>();
for (Integer value1 : set) {
    if (used.contains(value1))
        continue; // already processed
    Integer value2 = target - value1;
    if (! value2.equals(value1) && set.contains(value2)) {
        used.add(value1);
        used.add(value2);
        System.out.println("(" + value1 + "," + value2 + ")");
    }
}
set.removeAll(used); // optional