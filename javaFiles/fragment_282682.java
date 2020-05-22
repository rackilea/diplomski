final Pattern pattern = Pattern.compile("\\d+"); // the regex
final Matcher matcher = pattern.matcher("ali123hgj"); // your string

final ArrayList<Integer> ints = new ArrayList<Integer>(); // results

while (matcher.find()) { // for each match
    ints.add(Integer.parseInt(matcher.group())); // convert to int
}