StringBuilder sb = new StringBuilder();
    Formatter formatter = new Formatter(sb, Locale.US);

    formatter.format("%1$-15s %2$-15s %3$-15s %4$-15s\n", "testing", "testing", "testing", "testing");
    formatter.format("%1$-15s %2$-15s %3$-15s %4$-15s", "testingggg", "testingggg", "testingggg", "testingggg");

    System.out.println(sb.toString());