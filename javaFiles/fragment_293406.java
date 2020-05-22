Scanner reader = new Scanner(System.in);
System.out.println("Enter the first file path");
String fileA = reader.next();
System.out.println("Enter the second file path");
String fileB = reader.next();

try {

    // Read from and cache fileA
    StringBuilder cache = new StringBuilder();
    BufferedReader readerA = new BufferedReader(new FileReader(new File(fileA)));
    String line = null;
    while((line = readerA.readLine()) != null) {
        cache.append(line);cache.append("\n");
    }
    readerA.close();

    // Read from fileB and overwrite to fileA
    FileWriter writerB = new FileWriter(new File(fileA));
    BufferedReader readerB = new BufferedReader(new FileReader(new File(fileB)));
    line = null;
    while((line = readerB.readLine()) != null) {
        writerB.write(line);writerB.write("\n");
    }
    writerB.close();
    readerB.close();

    // Append original fileA content back into fileA
    FileWriter writerA = new FileWriter(new File(fileA), true);
    writerA.write(cache.toString());
    writerA.close();

} catch (Exception e) {
    e.printStackTrace();
}