// All exceptions handled within the method -- except if you rethrow it
public void readFile(final String file)
{
    final Path path = Paths.get(file);
    try (
        final BufferedReader reader = Files.newBufferedReader(path,
            StandardCharsets.UTF_8);
    ) {
        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
    } catch (FileSystemException e) {
        // deal with a filesystem-level error
        // Note that you MUSt catch it before IOException
        // since FileSystemException inherits IOException
    } catch (IOException e) {
        // deal with a low-level I/O error
    }
}