jshell> String[] data = { "apple", "pear", "orange", "cherry" };
data ==> String[4] { "apple", "pear", "orange", "cherry" }

jshell> var map = Arrays.stream(data)
   ...>                 .collect(Collectors.toMap(s -> s,
   ...>                                           s -> s.length(),
   ...>                                           (a,b) -> a,
   ...>                                           TreeMap::new));
map ==> {apple=5, cherry=6, orange=6, pear=4}