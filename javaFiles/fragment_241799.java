Set<Integer> set = new HashSet<>();
for (int value : x) {
    if (!set.add(value)) {
        // Or whatever you want to do
        System.out.println("Detected a duplicate... " + value);
    }
}