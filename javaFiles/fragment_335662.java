@Override
    protected String doInBackground(String... urls) throws IOException {
        URLConnection connection = new URL(urls[0]).openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()),"UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        String buffer;
        while ((buffer = bufferedReader.readLine()) != null) {
            stringBuilder.append(buffer);
        }
        return stringBuilder.toString();
    }