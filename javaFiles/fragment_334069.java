public static String getMatch(final String pattern, final String content) {
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(content);

    if (m.find()) {
        return m.group(1);
    } else {
        return "";
    }
}

public static void load(String fileName) throws FileNotFoundException {

    List<String> places = new ArrayList<String>();
    List<String> names = new ArrayList<String>();
    List<String> nameDetails = new ArrayList<String>();

    BufferedReader br = new BufferedReader(new FileReader(fileName));

    String text;
    String lastName = "";

    try {

        while ((text = br.readLine()) != null) {
            // extract num from start of line or empty if none..
            String num = getMatch("^([0-9]+)\\.", text);

            if (text.contains("Place:")) {
                text = text.replaceAll("Place:", "");
                places.add(text);
            } else if (text.contains(num + ". Name:")) {
                text = text.replaceAll(num + ". Name:", "");
                names.add(text);
                lastName = text;
            } else if (text.contains(num + ". Name detail:")) {
                text = text.replaceAll(num + ". Name detail:", "");
                nameDetails.add(lastName + " had " + text);
            }
        }
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }

    System.out.println("Places:" + places);
    System.out.println("Names:" + names);
    System.out.println("Name Details:" + nameDetails);
}