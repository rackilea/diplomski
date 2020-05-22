String[] intParts = yourString.split("\\s+");
ArrayList<Integer> myInts = new ArrayList<Integer>();

for (String intPart : intParts) {
  myInts.add(Integer.parseInt(intPart));
}