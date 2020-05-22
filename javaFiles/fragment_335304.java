public class FileCopy {

    public static void recursivelyCopyContent(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                recursivelyCopyContent(fileEntry);
            } else if (fileEntry.getName().substring(0, fileEntry.getName().lastIndexOf(".")).toLowerCase().equals(folder.getName().toLowerCase())) {
                // just pass the folder and the file to the method that will do the actual content copy 
                copyContent(folder, fileEntry);
            }
        }
    }

    public static void copyContent(final File folder, final File fileName) {
        try {
             // get the byte[] content of the source file
            byte[] fileContent = Files.readAllBytes(fileName.toPath());
            for (final File fileEntry : folder.listFiles()) {
                // only select files with a different absolute path than the source one
                if(fileEntry.isFile() && !fileEntry.getAbsolutePath().equals(fileName.getAbsolutePath())) {
                    // append contents from source to destination file 
                    Files.write(fileEntry.toPath(), fileContent, StandardOpenOption.APPEND);
                }
            }
        }catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        final File folder = new File("/path-of-directory/");
        FileCopy.recursivelyCopyContent(folder);
    }
}