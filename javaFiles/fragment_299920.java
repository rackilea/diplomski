Hashtable<String, int[]> result = new Hashtable<String, int[]>();
Pattern pattern = Pattern.compile("([A-Z]+):(\\d+(?:,\\d+)*)");
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    String key = matcher.group(1);
    String[] fields = matcher.group(2).split(",");

    int[] values = new int[fields.length];
    for (int i=0; i<values.length; i++)
        values[i] = Integer.parseInt(fields[i]);

    result.put(key, values);
}