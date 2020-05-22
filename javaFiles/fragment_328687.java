private void lines(InputStream inputStream) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    String line = "";
    do {
        System.out.println(line); // will print an empty line to start
    } while ((line = br.readLine()) != null);

    System.out.println(line); // will print null

}