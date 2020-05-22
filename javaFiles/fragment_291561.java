@Configuration
@ConditionalOnClass(name = Constants.DB2_PRESENCE_TOKEN_CLASS)
@AutoConfigureAfter(value = {
        DataSourceAutoConfiguration.class})
@Slf4j
public class Db2CustomPropertiesAutoConfiguration implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("bean {}", bean);
        if (bean instanceof DataSourceProxy && ((DataSource) bean).getDriverClassName().equals("com.ibm.db2.jcc.DB2Driver")) {
            ((DataSource) bean).getDbProperties().put("clientDebugInfo", "XXX")
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}