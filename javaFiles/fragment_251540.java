import org.apache.shiro.mgt.SecurityManager;
...

public static void main(String[] args) throws Exception {

    String resource = "/META-INF/spring/beans.xml";

    ClassPathXmlApplicationContext appCtx = 
        new ClassPathXmlApplicationContext(resource);

    SecurityManager securityManager = 
        (SecurityManager)appCtx.getBean("securityManager");

    SecurityUtils.setSecurityManager(securityManager);

}