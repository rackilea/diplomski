public class CustomFileListFilter extends AcceptOnceFileListFilter<File> {

    @Override
    public boolean accept(File file) {

        try {
            FileInputStream stream = new FileInputStream(file);
            stream.close();
        }
        catch (IOException e) {
            log.error("File not readable");
            return false;
        }

        return super.accept(file);
    }

}