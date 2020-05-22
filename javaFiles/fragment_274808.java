public class CsvFileHelper {

    private final String fileDownloadType;

    public CsvFileHelper(String type) {
        fileDownloadType = type;
    }

    public void parseDataAndGenerateFile() {
        createHeader();
        generateFile();
    }

    public void createHeader() {
        if ("expired".equals(fileDownloadType)) {

        } else {

        }
    }

    public void generateFile() {
        if ("expired".equals(fileDownloadType)) {

        } else {

        }
    }
}

public class TemplateMethodMain {

    public static void main(String[] args) {
        CsvFileHelper csvDataParser = new CsvFileHelper("expired");
        csvDataParser.parseDataAndGenerateFile();
    }
}