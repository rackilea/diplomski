public class FileFormat {
    public enum FileType { WINDOWS, UNIX, MAC, UNKNOWN }

    private static final char CR = '\r';
    private static final char LF = '\n';

    public static FileType discover(String fileName) throws IOException {    

        Reader reader = new BufferedReader(new FileReader(fileName));
        FileType result = discover(reader);
        reader.close();
        return result;
    }

    private static FileType discover(Reader reader) throws IOException {
        int c;
        while ((c = reader.read()) != -1) {
            switch(c) {        
            case LF: return FileType.UNIX;
            case CR: {
                if (reader.read() == LF) return FileType.WINDOWS;
                return FileType.MAC;
            }
            default: continue;
            }
        }
        return FileType.UNKNOWN;
    }
}