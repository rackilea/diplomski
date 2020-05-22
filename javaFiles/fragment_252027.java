@Component
public class DummyTask implements Runnable {

    @Autowired
    private FileService fileService;


    @Override
    public void run() {
        fileService.runtask(blah);
    }
}