private static final String FILE_NAME = "indexFile";
private static int[] anArray = { 100, 200, 300};

public static void main(String args[]) throws IOException {
    System.out.println(anArray[getIndex()]);

}

private static Integer getIndex() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
    int index = Integer.parseInt(in.readLine());
    in.close();

    Integer newIndex = (index >= anArray.length - 1) ? 0 : index + 1;
    Writer out = new OutputStreamWriter(new FileOutputStream(FILE_NAME));
    out.write(newIndex.toString());

    out.close();
    return index;
}