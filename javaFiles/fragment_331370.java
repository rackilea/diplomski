@Service
public class MyPropertiesServ implements InitializingBean {

@Autowired
protected ApplicationContext context;
private Properties properties;

private static MyPropertiesServ singleInst;

protected MyPropertiesServ () {
    properties = new Properties();
    singleInst= this;
}

@Override
public void afterPropertiesSet() throws Exception {
    properties.load(context.getResource("classpath:file.properties").getInputStream());
}

public static String getStringProperty(String key) {
    return singleInst.properties.getProperty(key);
}

}