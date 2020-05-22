long numberofLines = 0;
try (Stream<String> stream = Files.lines(filePath)) {
        numberOfLines = stream.count();
} catch (IOException ex) {
    //catch exception
}