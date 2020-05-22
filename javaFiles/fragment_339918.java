Pattern p = Pattern.compile("(.*?)[.\\s][sS](\\d{2})[eE](\\d{2}).*");

String[] tests = { "xyz title name S01E02 bla bla",
                   "bla bla title name.S03E04",
                   "the season title name s05e03" };

for (String s : tests) {
    Matcher m = p.matcher(s);
    if (m.matches())
        System.out.printf("Name: %-23s Season: %s Episode: %s%n",
                m.group(1), m.group(2), m.group(3));