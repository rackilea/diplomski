Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s\\[D\\].+<MBXID>(\\d+)<\\/MBXID><MBXTO>(\\d+)<\\/MBXTO>.+<MSGTEXT>(.+)<\\/MSGTEXT>", Pattern.MULTILINE + Pattern.DOTALL); 
// Multiline is used to capture the LANMSG more than once, and Dotall is used to make the '.' term in regex also match the newline in the input
Matcher matcher = pattern.matcher(input);
while (matcher.find()){
    String output = matcher.group(1) + " [" + matcher.group(2) + "] to [" + matcher.group(3) + "] " + matcher.group(4);
    System.out.println(output);
}