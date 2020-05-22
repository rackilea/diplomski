@Component
public class Schedule {
    @Autowired
    private LoginLog l;

    public void call(){
        System.out.println("In SC");
        l.loginEventLogging();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        Schedule s = context.getBean(Schedule.class)
        s.call();
    }
}