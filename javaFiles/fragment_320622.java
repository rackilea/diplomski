@RestController
@RequestMapping("/bean")
public class BeanRestController {

    @Autowired
    private SingletonBean singletonBean;

    @GetMapping("/name")
    public String getName() {
        return singletonBean.getPrototypeBean().getClass().getName();
    }

}