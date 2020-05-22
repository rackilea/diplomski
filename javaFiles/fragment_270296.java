StringNode buildStringNode(String sequence) {
  if (sequence.isEmpty()) return null;

  int middlePos = (sequence.length() + 1) / 2;
  char iData = sequence.charAt(middlePos);

  StringNode result = new StringNode(iData);
  result.leftChild = buildStringNode(sequence.substring(0, middlePos));
  result.rightChild = buildStringNode(sequence.substring(middlePos + 1));
  return result;
}