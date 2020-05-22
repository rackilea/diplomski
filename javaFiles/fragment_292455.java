public class InitBean implements ApplicationContextAware, InitializingBean {
    private ApplicationContext ctx;
    private Map<String, String> beanMap = new HashMap<String,String>();

    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        ctx = ac;
    }

    public void afterPropertiesSet() throws Exception {
        for(String beanName: ctx.getBeanNamesForType(GoBean.class)){
            beanMap.put(ctx.getBean(beanName).toString(), beanName);
        }
    }

    public Map<String,String> getBeanMap(){
        return beanMap;
    }    
}