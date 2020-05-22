final Pattern re1 = Pattern.compile(".*;BYDAY=(.*)");
final Pattern re2 = Pattern.compile("(?:([+-]?[0-9]*)([A-Z]{2}),?)");

final Matcher matcher1 = re1.matcher(rrule);
if ( matcher1.matches() ) {
    final String group1 = matcher1.group(1);
    Matcher matcher2 = re2.matcher(group1);
    while(matcher2.find()) {
        System.out.println("group: " + matcher2.group(1) + " " +
                    matcher2.group(2));
    }
}