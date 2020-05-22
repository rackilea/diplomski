@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired private DirezioneRegionaleService service; 
    @Override public void run(String...args) throws Exception {
        List<DirezioneRegionale> dirRegs = service.getAllDirRegs();
        System.out.println(dirRegs);
    }
}