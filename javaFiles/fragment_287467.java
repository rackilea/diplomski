jshell> enum Level {
   ...>   LOW,
   ...>   MEDIUM,
   ...>   HIGH
   ...> }
|  created enum Level

jshell> Set<Level> levels = new HashSet<>(Arrays.asList(Level.LOW, Level.HIGH));
levels ==> [LOW, HIGH]

jshell> levels.stream().map(Enum::toString).collect(Collectors.joining(","))
$3 ==> "LOW,HIGH"