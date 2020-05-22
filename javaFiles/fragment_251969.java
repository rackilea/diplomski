String string = "aabbeeddffcc";

Set<Character> chars = new TreeSet<>();
for( char c : string.toCharArray() ) {
  chars.add(c);
}

System.out.println( chars );