String input = "Hello,World\\,,1,2,3";
String[] parts = input.split("(?<!\\\\),");
for (String part : parts) {
    // uncomment to also remove backslash
    // part = part.replaceAll("\\\\,", ",");
    System.out.println(part);
}