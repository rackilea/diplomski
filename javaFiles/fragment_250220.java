String sample = "3A/45 Jindabyne Rd, Oakleigh, VIC 3166";
    Pattern pattern = Pattern.compile("(([^/ ]+)/)?([^ ]+) ([^,]+), ([^,]+), ([^ ]+) (\\d+)");
    Matcher m = pattern.matcher(sample);
    if (m.find()) {
        System.out.println("Unit: " + m.group(2));
        System.out.println("Number: " + m.group(3));
        System.out.println("Street: " + m.group(4));
        System.out.println("Suburb: " + m.group(5));
        System.out.println("State: " + m.group(6));
        System.out.println("Postcode: " + m.group(7));
    } else {
        throw new IllegalArgumentException("WTF");
    }