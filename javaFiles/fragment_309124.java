@Service
public class SomeOtherBean {

    private Map<SomeEnum, EnumMappedBean> beansMappedByEnum;

    @Autowired
    public SomeOtherBean(@NonNull Map<SomeEnum, EnumMappedBean> beansMappedByEnum) {
        this.beansMappedByEnum = beansMappedByEnum;
    }
}