@SpringBootApplication
public class JobsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsApplication .class, args);
        }
     @Bean
     public BeanInOtherJar xxBean(){
        return new com.internal.jar.XXX();
     }
}