Pattern pattern = Pattern.compile("(.*)name(.*)");

for (String element : list) {
    if (pattern.matcher(element).matches()) {
        System.out.println("Found a match: " + element);
    }
}