abstract public class FileHelper {

    abstract String getFileDownloadType();

    public void parseDataAndGenerateFile() {
        createHeader();
        generateFile();
    }

    public void createHeader() {
        if ("expired".equals(getFileDownloadType())) {

        } else {

        }
    }

    public void generateFile() {
        if ("expired".equals(getFileDownloadType())) {

        } else {

        }
    }
}

public class ExcelDataParser extends FileHelper {
    @Override
    String getFileDownloadType() {
        return "expired";
    }
}

public class TemplateMethodMain {
    public static void main(String[] args) {
        ExcelDataParser csvDataParser = new ExcelDataParser();
        csvDataParser.parseDataAndGenerateFile();
    }
}