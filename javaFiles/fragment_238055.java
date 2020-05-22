@RestController
public class CreatingRepo {
    @Autowired
    BeanFactory beanFactory;

    @RequestMapping("/")
    public void postMessage() {
        // instead of new SomeBean we get it from the BeanFactory
        SomeRepo repo = beanFactory.getBean(SomeRepo.class);
    }
}