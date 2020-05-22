@Configuration
public class MonitoringContext
{
    @Bean(name="facadeMonitoringAdvisor")
    public MonitoringSpringAdvisor getMonitoringSpringAdvisor() {
         MonitoringSpringAdvisor msa = new MonitoringSpringAdvisor();
         msa.setPointcut(getJdkRegexpMethodPointcut());
         return msa;
    }

    @Bean
    public JdkRegexpMethodPointcut getJdkRegexpMethodPointcut() {
         JdkRegexpMethodPointcut jrm = new JdkRegexpMethodPointcut();
         jrm.setPatterns("com.abc.service.*.*(..)");
         jrm.setExcludedPatterns("com.abc.service.*.getEntityManager(),com.abc.service.xyz.integration.gateway.*,com.abc.service.xyz.webservice.*");
         return jrm;
    }
}