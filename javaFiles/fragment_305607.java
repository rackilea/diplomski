public static class Map extends Mapper<LongWritable, Text, Text, Text> {
    private static final HashMap<String, Integer> counter = new HashMap<>();
    private Text output = new Text();

    private String mapToString(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Object>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue().toString());
            if (iter.hasNext()) {
                sb.append(';').append(' ');
            }
        }
        return sb.toString();
    }

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // TODO: Get filename
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!counter.containsKey(token)) {
                counter.put(token, 1);
            } else {
                counter.put(token, (Integer) counter.get(token) + 1);
            }
        }
        output.set(mapToString(counter));
        context.write(new Text("filename"), output);
    }
}