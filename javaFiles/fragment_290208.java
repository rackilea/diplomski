public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("notepad.txt"));
    List<String> outputList = new ArrayList<>();

    String input = null;
    while (in.hasNextLine() && null != (input = in.nextLine())) {
        outputList.add(input);
    }

    String[] outputArray = new String[outputList.size()];
    outputArray = outputList.toArray(outputArray);

    in.close();
}