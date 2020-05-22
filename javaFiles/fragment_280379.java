Stream<Integer> sorted = Stream.of(1, 2, 3).sorted();
    System.out.println((sorted.spliterator().hasCharacteristics(Spliterator.SORTED));

    sorted = Stream.of(1, 2, 3).sorted().unordered();
    System.out.println((sorted.spliterator().hasCharacteristics(Spliterator.SORTED));

    Stream<Integer> unordered = Stream.of(1, 2, 3).unordered();
    System.out.println((unordered.spliterator().hasCharacteristics(Spliterator.SORTED));

    unordered = Stream.of(1, 2, 3);
    System.out.println((unordered.spliterator().hasCharacteristics(Spliterator.SORTED));