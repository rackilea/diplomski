String input = "Jim ate a [sandwich] with [pickles] and [dried [onions]] and ] [an[other] match]";
List<String> balanced = getBalancedSubstrings(input, '[', ']', true);
System.out.println("Balanced ones: " + balanced);
List<String> rx_split = new ArrayList<String>();
for (String item : balanced) {
    rx_split.add("\\s*" + Pattern.quote(item) + "\\s*");
}
String rx = String.join("|", rx_split);
System.out.println("In-betweens: " + Arrays.toString(input.split(rx)));