@RestController
public void MyController {

    @Inject
    private MySingletonBean mySingletonBean;

    @RequestMapping("/")
    public String index() {
        String key = mySingletonBean.getKey();
        return key;
    }
}