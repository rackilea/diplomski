@Component
public class MyJobSetup {
    List<String> fileNames;

    public List<String> getFileNames() {
        return fileNames;
    }

    @PostConstruct
    public void afterPropertiesSet() {
        // read the filenames and store dem in the list
        fileNames = ....;
    }
}