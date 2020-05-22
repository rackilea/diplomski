@SpringBootApplication
public class NotifyMain implements CommandLineRunner {

@Autowired
private NotifyService notifyService;

public static void main(String[] args) {
    SpringApplication.run(NotifyMain.class, args);
}

@Override
public void run(String... args) {
    Timer timer1 = new Timer();
    timer1.schedule(notifyService, 10, 10);
}