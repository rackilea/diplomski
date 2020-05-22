public static void main(String [] args) throws IOException {

    InputStream inputStream = new ByteArrayInputStream("{\"name\":\"Camilo\",\"functionName\":\"hello\"}".getBytes());
    OutputStream outputStream = new ByteArrayOutputStream();

    LambdaExecutor lambdaExecutor = new LambdaExecutor();


    String test = IOUtils.toString(inputStream); //this consumes the stream, and nothing more can be read from it
    lambdaExecutor.handleRequest(inputStream,outputStream);
}