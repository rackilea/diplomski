@Component
public class FileProcessingCommandLine implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        for (String filename : applicationArguments.getNonOptionArgs()) 
           File file = new File(filename);
           service.doSomething(file);
        }
    }
}