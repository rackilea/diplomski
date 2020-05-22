public JavaRDD<String> getIPs(JavaRDD<String> rdd) {
    final String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    final Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);

    return rdd.flatMap(new FlatMapFunction<String, String>() {
        @Override
        public Iterable<String> call(String t) throws Exception {
            final Matcher matcher = pattern.matcher(t);
            final LinkedList<String> matches = new LinkedList<>();
            while (matcher.find()) {
                matches.add(matcher.group());
            }
            return matches;
        }
    });
}