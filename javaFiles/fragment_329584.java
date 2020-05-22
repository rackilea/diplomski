StringTokenizer st = new StringTokenizer(input);

while (st.hasMoreTokens()) {
  word = st.nextToken();

  while (st.hasMoreTokens()) {
    if (st.nextToken().equals(word)) {
      count++;
    }
  }
  System.out.println(word + ": " + count);
  input = input.replaceAll(word, "");
  count = 1;
  st = new StringTokenizer(input);
}