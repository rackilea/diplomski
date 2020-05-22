Pattern p = Pattern.compile("^2(2[4-9]|3\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    Matcher m = p.matcher("224..");

    if (!m.matches() && !m.hitEnd()) {
        System.out.println("Invalid");
    } else {
        System.out.println("Valid");
    }