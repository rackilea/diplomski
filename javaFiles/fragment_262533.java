private FileWriter fileWriter;

public Logging() {
    super();
    try {
       fileWriter = new FileWriter(file);
    }
    catch (IOException e) {
       throw new RuntimeException(e);
    }
}