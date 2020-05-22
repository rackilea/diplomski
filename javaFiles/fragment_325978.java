String str = "2 4.0 6.0 7 8 4.60";
    Pattern pattern = Pattern.compile("(?<=^|[ ])(\\d+)(?=[$ ])");

    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
        System.out.print(matcher.group(1) + " ");
    }