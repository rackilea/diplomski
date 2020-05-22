Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

Predicate<Integer> predicate = s -> s % 2 == 0;
Predicate<Integer> predicate2 = predicate.or(s -> s % 3 == 0);
set.removeIf(predicate2);

// Test with set.removeIf(predicate);
// then with set.removeIf(predicate2);
// and compare results