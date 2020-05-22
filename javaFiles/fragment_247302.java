char[] chars = "text not text".toCharArray();

List<String> results = new ArrayList<String>();
StringBuilder builder = new StringBuilder();

for (int i = 0; i < chars.length; i++) {
  char c = chars[i];

  builder.append(c);

  if (c == ' ' || i == chars.length - 1) {
    results.add(builder.toString().trim());
    builder = new StringBuilder();
  }
}

for (String s : results) {
  System.out.println(s);
}