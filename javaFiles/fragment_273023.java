String temp = "[a, b, c, d]";

// trim enclosing brackets and then split by comma and space
String[] array = temp.substring(1, temp.length() - 1).split(", ");

List<String> list = new ArrayList<String>();

for (String s : array) {
    list.add(s);
}