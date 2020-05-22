public String setPassword(String username) {
        int passl = 8;
        String s = username;
        if (s.length() < passl) {
            s += "*";
        }
        if (s.length() > passl) {
            s = s.substring(0, passl);
        }

        s = s.replaceAll("(?i)[aeiou]", "*");   // (?i) for case insensitive
        Pattern pattern = Pattern.compile("([a-zA-Z])");  // any character
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            s = matcher.replaceFirst(matcher.group(0).toUpperCase());
        }

        return s;
    }