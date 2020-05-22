final Matcher matcher = YANG_FILENAME_PATTERN.matcher(file.getName());
if (!matcher.matches()) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line = reader.readLine();
        while (!DATE_PATTERN.matcher(line).find()) {  <--- Line 316
            line = reader.readLine();
        }
        ...
    }
}