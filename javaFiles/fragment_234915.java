StringBuilder exp = new StringBuilder();
for (String s : countries) {
  exp.append(exp.length() == 0 ? "(" : "|");
  exp.append(s);
}
Pattern countryPattern = Pattern.compile(exp.append(")").toString());