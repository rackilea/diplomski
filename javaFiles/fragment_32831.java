return loadSortedSparseNumbersObservable()
    .collect(
            () -> new numbers[1000],
            (array, number) -> {
                int index = computeTrueIndex(...);
                array[index] = number;
            }
    )
    .map(array -> );