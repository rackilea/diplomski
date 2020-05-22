String previous = tokenizer.nextToken();
while (tokenizer.hasMoreElements()) {
  String current = tokenizer.nextToken();
  String correctValue = previous + " " + current;

  previous = current;
}