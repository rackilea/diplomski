List<String> o;

// o can be one of the two following things
o = Arrays.asList("Toto", "tata", "Titi");
o = Collections.singletonList("Test");

o.forEach(System.out::println);