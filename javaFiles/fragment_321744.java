public class Test {

    private FileReaderFactory fileReaderFactory = new FileReaderFactory();

    public static void main(String[] args) {
        String fileTxt = "test1.txt";
        String filePdf = "test2.pdf";

        Test test = new Test();
        FileTypeI filereaderTxt = test.fileReaderFactory.createFromExtension(fileTxt);
        FileTypeI filereaderPdf = test.fileReaderFactory.createFromExtension(filePdf);

        filereaderTxt.readFile();
        filereaderPdf.readFile();
    }

    public interface FileTypeI {
        void readFile();
    }

    class TextFileReader implements FileTypeI {
        @Override
        public void readFile() {
            //Code to read Text File
        }
    }

    class PDFFileReader implements FileTypeI {
        @Override
        public void readFile() {
            //Code to read PDF File
        }
    }

    class FileReaderFactory {
        public FileTypeI createFromExtension (String filename) {
            FileTypeI returningValue = null;
            if (filename != null && filename.endsWith(".txt")) {
                returningValue = new TextFileReader();
            } 
            else if (filename != null && filename.endsWith(".pdf")) {
                returningValue = new PDFFileReader();
            }
            return returningValue;
        }
    }

}