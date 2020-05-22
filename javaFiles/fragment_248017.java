private List<String[]> getDataArray(String filename) throws IOException {
    List<String[]> data = new ArrayList<>();

    InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
    Scanner sc = new Scanner(is);

    while (sc.hasNextLine()) {
        data.add(sc.nextLine().split(":"));
    }

    return data;
}