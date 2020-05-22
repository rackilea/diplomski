public class FileUtil {
    String fileName;
    File file;
    boolean delete = true;


    public FileUtil(String fileName, File file) {
        super();
        this.fileName = fileName.substring(0, fileName.indexOf("."));
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public boolean isDelete() {
        return delete;
    }
    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "FileUtil [fileName=" + fileName + ", file=" + file + ", delete=" + delete + "]";
    }

}