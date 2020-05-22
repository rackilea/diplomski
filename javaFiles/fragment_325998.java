@Service @Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MyValidator {}

@Service
public class ValidatorHolder {
    @Autowired
    public ValidatorHolder(MyValidator myValidator){
        this.myValidator=myValidator;
    }
    private final MyValidator myValidator;
    public MyValidator getMyValidator(){ return myValidator; };
}