@Configuration
public class MyBatchConfiguration {

    @Bean
    public ExitCodeGenerator myExitCodeGenerator() {
        return new MyExitCodeGenerator();
    }

    @Bean
    public BatchDatabaseInitializer myBatchDatabaseInitializer() {
        return new MyBatchDatabaseInitializer();
    }

}