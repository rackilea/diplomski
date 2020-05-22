Set<String> users = new HashSet<>(Arrays.asList("Alice", "Bob"));

System.out.println(users.contains("Alice"));
// -> prints true

System.out.println(users.contains("Jack"));
// -> prints false