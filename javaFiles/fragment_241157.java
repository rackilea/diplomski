private static ApplicationContext context;

@Autowired
public void setContext(ApplicationContext context) {
       OrderFactory.context = context;
}