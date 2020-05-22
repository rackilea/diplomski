while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    Matcher m = Pattern.compile("((?:\\+|-)?\\d+)->((?:\\+|-)?\\d+)->((?:\\+|-)?\\d+)").matcher(line);
    if (m.matches()) {
        // m.group(1), m.group(2) and m.group(3) are the three values as strings. You can convert them to ints yourself.
        System.out.println(m.group(1) + " -> " + m.group(2) + " costs " + m.group(3));
    } else {
        System.out.println(line);
    }
}