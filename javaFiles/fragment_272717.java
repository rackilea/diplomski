String sentence1 = "Washington Apple Drink";
String sentence2 = "SUNFRESH Apple Drink RTS 1L";

List<String> sen1 = Arrays.asList(sentence1.split(" "));
List<String> sen2 = Arrays.asList(sentence2.split(" "));

for (String s : sen1) {
    if (sen2.contains(s)) {
        System.out.println("The word " + s + " appears in both sentences");
    }
}