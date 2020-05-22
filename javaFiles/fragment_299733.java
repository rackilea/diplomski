DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[[dd.]MM.]yyyy");
// correct dates
assert formatter.parse("31.12.2017") != null;
assert formatter.parse("12.2017") != null;
assert formatter.parse("2017") != null;
// wrong date
assert formatter.parse("31.2017") == null;