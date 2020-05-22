@Configuration
public class ServiceFactory {

@Autowired
ApplicationContext ctx;

public YourDependency createDependency(String identifier) {

    YourDependency yourDependency= null;

    switch (identifier) {
    case "1":
        yourDependency = ctx.getBean(YourDependency1.class);
        break;
    case "2":
        yourDependency = ctx.getBean(YourDependency2.class);
        break;
    case "3":
        yourDependency = ctx.getBean(YourDependency3.class);
        break;
    }
    return yourDependency;
}
}