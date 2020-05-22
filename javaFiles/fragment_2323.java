Set<Character> filter = new HashSet<>(Arrays.asList('a','b','c'));
String filtered = "abcdefga".chars ()
                            .filter(i -> filter.contains((char) i))
                            .mapToObj(i -> "" + (char) i)
                            .collect(Collectors.joining());
System.out.println (filtered);