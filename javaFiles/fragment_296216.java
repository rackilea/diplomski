public static void main(String [] args)
{
    List<String[]> cols;
    List<String[]> cols1;
    try {
        cols = readFile("udc.csv");
        cols1 = readFile("Watford Update File.csv");
    } catch (IOException e) {
        e.printStackTrace();
        return;
    }
    // loop through array lists to do your comparisons
    // For example, to compare the first column of rows i and j:
    //    cols.get(i)[0].equals(cols1.get(j)[0])
}

private static List<String[]> readFile(String fileName) throws IOException
{
    List<String[]> values = new ArrayList<String[]>();
    Scanner s = new Scanner(new File("udc.csv"));
    while (s.hasNextLine()) {
        String line = s.nextLine();
        values.add(line.split(","));
    }
    return values;
}