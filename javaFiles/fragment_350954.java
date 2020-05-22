String key = "aardvark".toLowerCase();
String alphabet = Arrays.stream(key.split("")).sorted().collect(Collectors.joining());
System.out.println("alphabet: " + alphabet);
int[] order = new int[key.length()];
for (int i = 0; i < key.length(); i++) {
  order[i] = alphabet.indexOf(key.charAt(i));
  alphabet = alphabet.replaceFirst( ""+key.charAt(i), "0" ); //Zero out chars as they are used
  System.out.println(order[i]);
}