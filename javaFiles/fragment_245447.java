// cast required
System.out.println(((Predicate<Character>) Character::isUpperCase).test('A'));

// no cast required
Arrays.asList("foo","bar").forEach(System.out::println);
Arrays.asList(1,2).forEach(i -> System.out.println(i*2));