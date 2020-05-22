List<List<String>> theStrings ... coming from somewhere
String[][] stringsAsArray = new String[theStrings.length][];
for (int i=0; i<theStrings.length;i++) {
  List<String> aList = theStrings.get(i);
  stringsAsArray[i] = aList.toArray(new String[aList.size()]);
}