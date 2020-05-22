Pattern pattern = Pattern.compile("Rooms:\\s+(\\d+)");
    Matcher matcher = pattern.matcher("Rooms: 2 Bedrooms: 1 Surface: 37 m² ");

    if (matcher.find()) {
        System.out.println(matcher.group(1)); // output 2 only
    }