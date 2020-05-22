@Component
public class AnyComponent {

    @Autowired
    private ApplicationContext applicationContext;

    public void invokeCoach() {
        System.out.println(applicationContext.getBean("tennisCoach"));
        System.out.println(applicationContext.getBean(SoccerCoach.class));
    }

}