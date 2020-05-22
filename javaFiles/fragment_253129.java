public static class MyReducer extends Reducer<NullWritable, Text, NullWritable, Text> {
    private Text result = new Text();
    private TreeMap<Double, Text> k_closest_points = new TreeMap<Double, Text>();

    public void reduce(NullWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        Configuration conf = context.getConfiguration();
        int K = Integer.parseInt(conf.get("K"));

        for (Text value : values) {
            String v[] = value.toString().split("@");
            if(v.length < 2)
                continue; // consider adding an enum counter

            double distance = Double.parseDouble(v[1]);
            k_closest_points.put(distance, new Text(v[0])); // you've already split once, why do it again later?

            if (k_closest_points.size() > K)
                k_closest_points.remove(k_closest_points.lastKey());
        }


        // exit early if nothing found
        if(k_closest_points.isEmpty())
            return;


        TreeMap<String, Integer> class_counts = new TreeMap<String, Integer>();
        for (Text value : k_closest_points.values()) {
            String tmp = value.toString();
            Integer current_count = class_counts.get(tmp);

            if (null != current_count) // avoid second lookup
                class_counts.put(tmp, current_count + 1);
            else
                class_counts.put(tmp, 1);
        }

        context.write(NullWritable.get(), new Text(class_counts.lastKey()));
    }
}