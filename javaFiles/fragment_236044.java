try (InputStream is = Controller.class.getResourceAsStream("/sample/Untitled.html");
     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }
}