Spliterator<String> spliterator = Arrays.asList("a", "b", "c").spliterator();
System.out.println(spliterator.estimateSize());

try {
    spliterator.forEachRemaining(s -> {
        if (s.equals("b")) {
            throw new IllegalArgumentException();
        }
        System.out.println(s);
    });
} catch (IllegalArgumentException e) {}

System.out.println(spliterator.estimateSize());
spliterator.forEachRemaining(System.out::println);