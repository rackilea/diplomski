final int[] firstSequence = new int[8];
final int[] secondSequence = new int[8];

// Exchange with the correct upperBound, I assume it is 9
final Set<Integer> numbers = randomUniqueNumbers(16, 9);

Iterator<Integer> numberIter = numbers.iterator();
// Fill the first sequence
for (int i = 0; i < 8; i++) {
    firstSequence[i] = numberIter.next();
}
// Fill the second sequence
for (int i = 0; i < 8; i++) {
    secondSequence[i] = numberIter.next();
}