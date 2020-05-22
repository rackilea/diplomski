public static void main(String[] args) {
    String line = "\"BEEP\",\"BOOP\",\"TWO SHOTS\rOF VODKA\"\r\"BOOP\",\"BEEP\",\"LEMON\rWEDGES\"";

    String quote = "\"";
    String splitter = "\r";
    String delimiter = ",";

    parse(line, delimiter, quote, splitter);
}

public static void parse(String data, String delimiter, String quote, String splitter) {
    String regex = splitter+"(?=(?:[^"+quote+"]*\"[^"+quote+"]*\")*[^"+quote+"]*$)";

    String[] lines = data.split(regex, -1);

    List<String[]> records = new ArrayList<String[]>();

    for(String line : lines) {
        records.add(line.split(delimiter, -1));
    }

    for(String[] line : records) {
        for(String record : line) {
            System.out.println("RECORD: " + record); //do whatever
        }
    }
}