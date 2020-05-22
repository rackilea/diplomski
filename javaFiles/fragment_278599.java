final String[] sqls = {
        "CREATE INDEX blah_idx ON blah (id ASC)",
        "CREATE INDEX blah2_idx ON blah2 (foo ASC, id DEC)",
        "CREATE INDEX blah2_idx ON blah2 (foo ASC, id DEC, name ASC)",
    };

    final Pattern createIndexPattern = Pattern.compile(
      "CREATE INDEX (\\w+) ON (\\w+) \\(((\\w+) (ASC|DESC)(, (\\w+) (ASC|DEC))*)\\)");
    for (String sql : sqls) {
        System.out.println("SQL: " + sql);
        Matcher m = createIndexPattern.matcher(sql);
        if (!m.matches()) {
            System.out.println("No match!");
        } else {
            System.out.println("Match!");
            int groupCount = m.groupCount();
            for (int groupI = 1; groupI <= groupCount; ++groupI) {
                System.out.printf("[%d] %s%n", groupI, m.group(groupI));
            }
            String[] fieldsWithOrdering = m.group(3).split(",\\s*");
            System.out.println(Arrays.toString(fieldsWithOrdering));
        }
    }