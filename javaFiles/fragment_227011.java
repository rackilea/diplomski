Pattern p = Pattern.compile("(?:\\.[1-9]+|(?=\\.))(\\.?0\\d*)");

String[] strs = {"180.570123", "180.570", "180.0123", "180.0", "180123", "180", "180.2030405"};

for (String s : strs) {
    Matcher m = p.matcher(s);
    System.out.printf("%-12s: Match: %s%n", s,
        m.find() ? m.group(1) : "n/a");
}