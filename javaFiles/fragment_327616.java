@Configuration
public class Cfg {

    public ExecutorService executorService() {
        return executorServiceFactoryBean().getObject();
    }

    @Bean
    public ThreadPoolExecutorFactoryBean executorServiceFactoryBean() {
        return new ThreadPoolExecutorFactoryBean();
    }

}