public static void main(String args[]) {
    String s = "Start successful - User:Berord; Name:Test; Fruits:Orange; Version:;";

    // provide a data structure that holds the desired key-value pairs
    Map<String, String> kvMap = new HashMap<>();

    // (#1) split the input by minus ('-') to get rid of the leading part
    String[] splitByMinus = s.split("-");

    // check if the result length is the expected one
    if (splitByMinus.length == 2) {
        // (#2) take the desired part and split it again, this time by semicolon (';')
        String[] splitBySemicolon = splitByMinus[1].split(";");

        for (String ss : splitBySemicolon) {
            // (#3) split the result of the splitting by semicolon another time, this time
            // by a colon (':')
            String[] splitByColon = ss.split(":");

            // again, check the length of the result
            if (splitByColon.length == 2) {
                // if yes, you have successfully extracted the key and value, erase leading and
                // trailing spaces
                String key = splitByColon[0].trim();
                String value = splitByColon[1].trim();

                // check if the map contains the key
                if (kvMap.containsKey(key)) {
                    // YOU DECIDE: skip this entry or update the existing key with the new value
                    System.out.println("There already is a key " + key + ". What now?");
                } else {
                    // if the map doesn't have the key, insert it along with the value
                    kvMap.put(key, value);
                }
            } else if (splitByColon.length == 1) {
                System.out.println(
                        "There was a key or value missing the corresponding key or value: \"" 
                        + splitByColon[0].trim()
                        + "\" (splitting by colon resulted in only one String!)");

                // for the moment, we regard this case as a key without a value
                String key = splitByColon[0].trim();

                // check if the map contains the key
                if (kvMap.containsKey(key)) {
                    // YOU DECIDE: skip this entry or update the existing key with the new value
                    System.out.println("There already is a key " + key
                            + ". What now? This time there is no new value, "
                            + "so skipping this entry seems a good idea.");
                    // do nothing...
                } else {
                    // if the map doesn't have the key, insert it along with the value
                    kvMap.put(key, null);
                }
            } else {
                System.err.println("Splitting by colon resulted in an unexpected amount of Strings,"
                        + "here " + splitByColon.length);
            }
        }

    } else {
        System.err.println("Splitting the input String resulted in an unexpected amount of parts");
    }

    // finally print your results that are stored in the map:
    kvMap.forEach((key, value) -> System.out.println(key + " : " + (value == null ? "" : value)));
}