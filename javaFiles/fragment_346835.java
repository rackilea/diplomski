Pattern p =
            Pattern.compile("(\\[.*?\\]|\".*?\")?.*?(\\d{1,3}(?:,\\d{3})*?(?:\\.\\d+)?).*?(\\[.*?\\]|\".*?\")",
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    Matcher m = p.matcher(textToMatch);
    if (m.find()) {
        for (int groups = 0; groups <= m.groupCount(); groups++) {
            System.out.println("Group " + groups + " contains " + m.group(groups));
        }
    }