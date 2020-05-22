@Component
@DependsOn("springContextUtil")
public class ConfigUtil {

    private String env;

    @PostConstruct
    private void init() {
        env = SpringContextUtil.getActiveProfile();
    }


    public static void getVal(String key) {
        System.out.print("Hello");
    }
}