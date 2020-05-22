String fileName = "test.java";
String outputFileName = String.format("%s.txt", fileName.replace('.', '_'));
try (BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(new FileWriter(outputFileName))) {
    int count = 1;
    String line;
    while ((line = br.readLine()) != null) {
        pw.printf("%03d %s%n", count, line);
        count++;
    }
} catch (Exception e) {
    e.printStackTrace();
}