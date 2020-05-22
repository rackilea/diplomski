String input = "456-67-8901";

    Pattern p = Pattern.compile("^(\\d{3}[- ]?\\d{2}[- ]?)(\\d{4})$");
    Matcher m = p.matcher(input);
    if (m.matches()) {
        System.out.println("XXX-XX-" + m.group(2));
    } else {
        // bad input
    }