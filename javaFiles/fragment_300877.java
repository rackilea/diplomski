int[] inputVector = new int[]{6, 2, 4, 9, 1, 3};
Set<Integer> uniqueVector = new HashSet<>();
int[] duplicates = Arrays.stream(inputVector)
        .filter(i -> !uniqueVector.add(i))
        .sorted().toArray();

if (duplicates.length > 0) {
    System.out.println(Arrays.toString(duplicates));
} else {
    System.out.println(0);
}