StringBuilder stringBuilder = new StringBuilder();
  Formatter formatter = new Formatter(stringBuilder);
  int maxSomething = 12;
  String template = metric + " %s %s sensor=%c cell=" + cellName + nl;
  for (int i = 0; i < ds.size()-counter-1; i = i + counter) {
     for (int j = 0; j < maxSomething; j++) {
        formatter.format(template, ds.get(i), ds.get(i + j + 2), (char)('A' + j));
     }
  }
  // the toString() below isn't necessary but is present for clarity
  System.out.println(stringBuilder.toString());
  formatter.close();