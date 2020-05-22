@Configuration
public class PaymentFactory {

    //private ApplicationContext applicationContext;

    public PaymentFactory() {      
        //this.applicationContext = applicationContext;
    }

    @Bean
    public PaymentService paymentService(JobService jobService, UserService userService
    , WorkService workService, ApplicationService applicationService){

        if(condition == true){
            return new PaymentServiceImplA(jobService, userService, workService,
    applicationService);
        }
        else {
            return new PaymentServiceImplB(jobService, userService, workService,
    applicationService);
        }
    }
}