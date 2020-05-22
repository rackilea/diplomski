Random random = new Random();
List<Integer> unsorted = random.ints(1, 64)
        .distinct()
        .limit(8)
        .boxed()
        .collect(Collectors.toList());

// here you need to get the last element that you don't want to sort
int last = unsorted.get(unsorted.size() - 1);
// here is the lambda
List<Integer> sorted = unsorted.stream().sorted((x, y) -> {
    if (Integer.compare(x, y) == 0) {
        return 0;
    }
    // if any one of the arguments is the last one...
    if (last == x) {
        return 1;
    }
    if (last == y) {
        return -1;
    }
    return Integer.compare(x, y);
}).collect(Collectors.toList());
// you can also use "List.sort" with the same lambda