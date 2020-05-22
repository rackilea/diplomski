@Service
public class UploadService {

@Value("${app.image.cdn}")
private String imageCDN;

@Value("${app.upload.path}")
private String uploadPath;

private Path rootLocation;


public String store(MultipartFile file) {

    String storedLocation;
    rootLocation = Paths.get(uploadPath);

    String filename = StringUtils.cleanPath(file.getOriginalFilename());
    filename = filename.toLowerCase().replaceAll(" ", "-");

    try {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file " + filename);
        }
        if (filename.contains("..")) {
            // This is a security check
            throw new StorageException(
                    "Cannot store file with relative path outside current directory "
                            + filename);
        }
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename),
                StandardCopyOption.REPLACE_EXISTING);

        storedLocation = imageCDN+filename;

    }
    catch (IOException e) {
        throw new StorageException("Failed to store file " + filename, e);
    }


    return storedLocation;
}
}