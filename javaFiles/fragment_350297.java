File file = new File("program.properties");
try (FileOutputStream fileStream = new FileOutputStream(file)) {
    write(fileStream, "username=max");
    write(fileStream, "score=12550");
    write(fileStream, "level=5");
    fileStream.flush();
} catch (IOException ioe) {
    System.out.println("Could not write file");
}