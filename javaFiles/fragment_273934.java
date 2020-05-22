String text = "12345678";
int splitAfter = 3;
List<String> tmpListFirst = new LinkedList<>();
List<String> tmpListSecond = new LinkedList<>();
tmpListFirst.add(text.substring(0, splitAfter));
tmpListSecond.add(text.substring(splitAfter));