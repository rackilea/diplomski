public void showFileContents() throws Exception {
    Path path = Paths.get(this.getClass().getResource("bar.txt").getPath());

    // read each line one at a time
    List<String> lines = Files.readAllLines(path);

    List<String> firstColumn = new ArrayList<>();
    List<String> secondColumn = new ArrayList<>();

    // Loop through each line and do whatever you want with them
    for (String line : lines) {
        String[] strValue = line.split(",");
        firstColumn.add(strValue[0]);
        secondColumn.add(strValue[1]);
    }

    // Looks like you wanted them separated by columns in one String, so that looks like:
    System.out.println("Values from first column:");
    System.out.println(String.join(",", firstColumn));
    System.out.println("Values from second column:");
    System.out.println(String.join(",", secondColumn));
}