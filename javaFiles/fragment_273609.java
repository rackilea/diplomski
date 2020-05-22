public static void main(String... args) throws IOException {

    ArrayList<ArrayList<String>> rows = getRandomData();

    if (rows.size() == 0)
        throw new RuntimeException("No rows");

    // normalize data
    int longest = 0;
    for (List<String> row : rows)
        if (row.size() > longest)
            longest = row.size();

    for (List<String> row : rows)
        while (row.size() < longest)
            row.add("");

    if (longest == 0)
        throw new RuntimeException("No colums");

    // fix special characters
    for (int i = 0; i < rows.size(); i++)
        for (int j = 0; j < rows.get(i).size(); j++)
            rows.get(i).set(j, fixSpecial(rows.get(i).get(j)));

    // get the maximum size of one column
    int[] maxColumn = new int[rows.get(0).size()];

    for (int i = 0; i < rows.size(); i++)
        for (int j = 0; j < rows.get(i).size(); j++)
            if (maxColumn[j] < rows.get(i).get(j).length())
                maxColumn[j] = rows.get(i).get(j).length();

    // create the format string
    String outFormat = "";
    for (int max : maxColumn)
        outFormat += "%-" + (max + 1) + "s, ";
    outFormat = outFormat.substring(0, outFormat.length() - 2) + "\n";

    // print the data
    for (List<String> row : rows)
        System.out.printf(outFormat, row.toArray());

}

private static String fixSpecial(String s) {

    s = s.replaceAll("(\")", "$1$1");

    if (s.contains("\n") || s.contains(",") || s.contains("\"") || 
            s.trim().length() < s.length()) {
        s = "\"" + s + "\"";
    }

    return s;
}

private static ArrayList<ArrayList<String>> getRandomData() {

    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    String[] rand = { "Do", "Re", "Song", "David", "Test", "4", "Hohjoh", "a \"h\" o", "tjo,ad" };
    Random r = new Random(5);

    for (int i = 0; i < 10; i++) {

        ArrayList<String> row = new ArrayList<String>();

        for (int j = 0; j < r.nextInt(10); j++)
            row.add(rand[r.nextInt(rand.length)]);

        data.add(row);
    }

    return data;
}