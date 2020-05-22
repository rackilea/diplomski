String regex = Stream.generate(() -> "\\d+").limit(allowedNumber + 1).collect(joining("\\D+", ".*", ".*"))

// non-stream equivalent
String regex = ".*\\d+";
for (int i = 0; i < allowedNumber; i++) {
    regex += "\\D+\\d+";
}
regex += ".*";

if (input.matches(regex)) {
    throw new RuntimeException(...);
}