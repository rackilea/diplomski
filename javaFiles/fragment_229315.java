Optional<Integer> odd = numbers.stream()
    .filter(n -> n % 2 != 0)
    .findAny();

boolean isEven = !odd.isPresent();

odd.ifPresent(x -> System.out.println(x + " is odd"));