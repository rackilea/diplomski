public class FileOperation {
    private File file;
    private FileStatus status;

    public FileOperation(File file, FileStatus status) {
        this.file = file;
        this.status = status;
    }

    public FileOperation(File file) {
        this(file, FileStatus.NOT_RUN);
    }

    public File getFile() {
        return file;
    }

    public FileStatus getStatus() {
        return status;
    }

    public void setStatus(FileStatus newStatus) {
        if (status == newStatus) {
            return;
        }
        this.status = newStatus;
    }

}