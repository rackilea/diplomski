String[] acceptedFormats = {"dd.MM.yyyy", "dd.MM.yyyy", "dd/MM/yyyy"};

// correct dates
assert DateUtils.parseDate("07.12.2017", acceptedFormats) != null;
assert DateUtils.parseDate("07.2017", acceptedFormats) != null;
assert DateUtils.parseDate("2017", acceptedFormats) != null;
assert DateUtils.parseDate("2017", acceptedFormats) != null;
// wrong dates
assert DateUtils.parseDate("123.2012", acceptedFormats) == null;
assert DateUtils.parseDate("01.13.2012", acceptedFormats) == null;