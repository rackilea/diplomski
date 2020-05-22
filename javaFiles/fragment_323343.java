public static void main(String[] args) throws Exception {

    List<String> headers = new ArrayList<String>();
    Scanner s = new Scanner(new File("2013ALL.csv"));
    String l = s.nextLine();
    while (s.hasNextLine() && l.startsWith("@")) {
        if (l.startsWith("@attribute")) {
            String[] splitLine = l.split(" ");
            headers.add(splitLine[1]);
        }
        l = s.nextLine();
    }

    System.out.println(headers);
}