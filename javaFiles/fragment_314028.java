StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

DataStream<String> inputURLs = env.fromElements("http://www.json.org/index.html");

inputURLs.map(new MapFunction<String, String>() {
    @Override
    public String map(String s) throws Exception {
        URL url = new URL(s);
        InputStream is = url.openStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        StringBuilder builder = new StringBuilder();
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line + "\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            bufferedReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return builder.toString();
    }
}).print();

env.execute("URL download job");