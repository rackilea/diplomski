private final Set<String> wordMoveTokens = new HashSet<String>(Arrays.asList("move", "mv", "moov"));
...
// substr = "move"
if (wordMoveTokens.contains(substr) ) {
   .... // True
}