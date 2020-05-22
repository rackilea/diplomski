Pattern p = Pattern.compile("^AAB/CC/(.+)/DD/(.+?)-(.+?)-(.+?)-(.+?)$");
    Matcher m = p.matcher(example2);

    if (m.find()) {
        System.out.println(m.group(1)); // all groups up to 5
    }