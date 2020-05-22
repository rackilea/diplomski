final String regex = "Object No: ([^|]*)\\| Item ID: (\\d*)";
    final String string = "Object No: NEW D City | Item ID: 1259669";

    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
            System.out.println(+ i + ": " + matcher.group(i));
        }
    }