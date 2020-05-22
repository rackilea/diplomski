@Service
public class MyFileService {

    private final StandardFileSystemManager manager;

    @Autowired
    public MyFileService(StandardFileSystemManager manager) {
        this.manager = manager;
    }

    public List<FileObject> listRemoteFiles() {
        try {
            manager.resolveFile(someURL);
        } finally {
            manager.close();
        }

        return Arrays.stream(remoteFiles)
                     .collect(Collectors.toList());
    }
}