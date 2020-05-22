@Component // defaults to eager initialization
class Setup {
    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void anyNameYouWant() {
        System.out.println("starting");
    }

    @PreDestroy
    public void hereToo() {
        System.out.println("closing");
    }
}