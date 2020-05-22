@Service
    public class FileStorageService {
        private FileStorageProperties props;
        // @Autowired is optional in this case
        public FileStorageService (FileStorageProperties fileStorageProperties) {
            this.props = fileStorageProperties;
            this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                    .toAbsolutePath().normalize();
        }

        @PostConstruct
        public void init() {
            try {
                Files.createDirectories(this.fileStorageLocation);
            } catch (Exception ex) {
                throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
            }
        }
    }