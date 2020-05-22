//Remember to set @EnableScheduling
//in the class containing your main method
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}

@Component
public class ScheduledTasks {

List<YourObject> myObjects;

    //This method will run every 5 second.
    @Scheduled(fixedDelay = 5000)
    public void yourMethodName() {
        //This will process all of your objects all at once using treads
        for(YourObject yo : myObjects){
            yo.process();
        }
    }
}

public class YourObject {

    Integer someTest = 0;

    @Async
    public void process() {
       someTest++;
    }
}