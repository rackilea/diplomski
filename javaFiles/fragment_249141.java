List<String> badGuys =
   Arrays.asList("Inky", "Blinky", "Pinky", "Pinky", "Clyde");
Function<String, Integer> stringLengthFunction = ...;
Multimap<Integer, String> index =
   Multimaps.index(badGuys, stringLengthFunction);
System.out.println(index);