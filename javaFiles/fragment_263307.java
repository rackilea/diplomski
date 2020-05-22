public class FileController {
    private FileStorageService service;

    public FileController(FileStorageService service) {
        this.service = service;
    }
}