public class DownloadAction extends ActionSupport{

    private InputStream fileInputStream;

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public String execute() throws Exception {
        fileInputStream = new FileInputStream(new File("location of your file"));
        return SUCCESS;
    }
}