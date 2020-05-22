public void read() throws IOException {
    File file = new File(FILE_INPUT_NAME);
    FileReader fr = new FileReader(file);
    BufferedReader readFile = new BufferedReader(fr);
    String line;
    while ((line = readFile.readLine()) != null) {
      String[] split = line.split(" ", 4);
      if (split.length != 4) { // Not enough tokens (e.g., empty line) read
        continue;
      }
      String id = split[0];
      String nameFromFile = split[1];
      String year = split[2];
      String mark = split[3];

      int idFromFile = Integer.parseInt(id);
      int yearOfStudyFromFile = Integer.parseInt(year);
      int markFromFile = Integer.parseInt(mark);

      //line = readFile.readLine();
      //readFile.readLine();
      //System.out.println(readFile.readLine());
    }
  }