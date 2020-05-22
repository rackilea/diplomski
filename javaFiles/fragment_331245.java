Object arr[] = new Object[10];
boolean empty = true;
for (int i=0; i<arr.length; i++) {
  if (arr[i] != null) {
    empty = false;
    break;
  }
}