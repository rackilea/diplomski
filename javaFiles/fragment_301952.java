List<Integer> coins1 = Arrays.asList(5, 5, 10);
List<Integer> coins2 = Arrays.asList(5, 10, 5);
List<Integer> coins3 = Arrays.asList(10, 10);

Set<Integer> dedupedCollection = new HashSet<Integer>();

dedupedCollection.add(coins1);
dedupedCollection.add(coins2);
dedupedCollection.add(coins3);

return dedupedCollection;