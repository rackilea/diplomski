try (InputStream is = connection.getInputStream()) {
  BufferedReader lines = new BufferedReader(new InputStreamReader(is, "UTF-8"));
  while (true) {
    String line = lines.readLine();
    if (line == null)
      break;
    System.out.println("Server Response " + line);
    ...
  }
}