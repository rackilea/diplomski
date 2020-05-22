Object arr[] = new Object[10];
boolean empty = true;
for (Object ob : arr) {
  if (ob != null) {
    empty = false;
    break;
  }
}