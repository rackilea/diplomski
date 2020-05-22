private FileWriter fileWriter;
{
    try {
       fileWriter = new FileWriter(file);
    }
    catch (IOException e) {
       throw new RuntimeException(e);
    }
}