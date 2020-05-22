List<String> view = logData1;
BitSet bits = new BitSet(logData1.size());
int emailIndex;
while ((emailIndex = Collections.lastIndexOfSubList(view, toFind)) >= 1) {
  bits.set(emailIndex-1, emailIndex+3);
  view = logData1.subList(0, emailIndex-1);
}