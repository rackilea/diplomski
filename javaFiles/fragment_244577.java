Set<String> x = new HashSet<String>();
x.add("foo");

ImmutableSet<String> guava = ImmutableSet.copyOf(x);
Set<String> builtIn = Collections.unmodifiableSet(x);

x.add("bar");
System.out.println(guava.size()); // Prints 1
System.out.println(builtIn.size()); // Prints 2