String str = "5B1 2B2 9B3 1R4 3R5 8R6 10R7";
List<String[]> list = new ArrayList<>();
String spl[] = str.split("\\s+");

for (String s : spl) {
   String sp[] = s.replaceAll("([a-zA-Z]+)", "$1-").replaceAll("([0-9]+)", "$1-").split("-");
   list.add(sp);
}