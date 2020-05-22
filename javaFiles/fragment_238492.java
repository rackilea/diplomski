public class FileSystemReader implements IReader{
        @Override
        public List<String> read(String fileLocation, Class clazz) throws IOException {
            return Files.readAllLines(Paths.get(getFile(fileLocation, clazz).getAbsolutePath()));
        }
    }