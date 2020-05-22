String[] textToArray;
try (Scanner reader = new Scanner(new File("document.txt"))) {
    List<String> textList = new ArrayList<>();
    for (String text; (text = reader.nextLine()) != null; ) {
        textList.add(text + "XXX");
    }
    textToArray = textList.toArray(new String[textList.size()]);
}