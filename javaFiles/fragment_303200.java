try (BufferedReader in = new BufferedReader(new FileReader(file))) {
    Pattern p = Pattern.compile("\\s+(\\w+)\\s+([0-9.]+)\\s*");
    for (String line; (line = in.readLine()) != null; ) {
        Matcher m = p.matcher(line);
        if (m.matches()) {
            String keyword = m.group(1);
            double number = Double.parseDouble(m.group(2));
            System.out.println(keyword + " = " + number);
        }
    }
}