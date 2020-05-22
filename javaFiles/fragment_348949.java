@Configuration
public class MyConfig {

    @Bean
    public MyService myService(){
        return new MyService();
    }

}


@Controller
public class Controller1 {

    @Autowire
    private MyService myService;

    @RequestMapping(value = "URL", method = RequestMethod.GET)
    public ModelAndView First(Parameters) { 
        myService.calculation();
    }
}

@Controller
public class Controller2 {

    @Autowire
    private MyBean myBean;

    @RequestMapping(value = "URL", method = RequestMethod.GET)
    public ModelAndView First(Parameters) { 
        myService.calculation();
    }
}