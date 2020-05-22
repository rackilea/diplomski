URL resourceUrl = getClass().getClassLoader().getResource("something");

    final StringBuilder builder = new StringBuilder();
    try {
        InputStream inputStream = resourceUrl.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            bufferedReader.lines().forEach(builder::append);
        } finally {
            bufferedReader.close();
            inputStream.close();
        }
    } catch (IOException ex){ //rethrow the same and handle in the calling function }