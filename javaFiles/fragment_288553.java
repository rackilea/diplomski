public static List<Book> getList(String file) {
    List<Book> list = new ArrayList<Book>();

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] bookDetails = line.split(",");
            if (bookDetails.length < 3) { // title,author,year
                System.err.println("Some error message here");
                continue;
            }

            list.add(new Book(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2])));

        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return list;
}