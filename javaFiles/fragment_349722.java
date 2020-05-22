try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
  String line;
  while (running) {
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    Thread.sleep(1000); // end of file has been reached, wait a second for more data
  }
} catch (FileNotFoundException ex) {
  // ...
} catch (IOException ex) {
  // ...
} catch (InterruptedException ex) {
}