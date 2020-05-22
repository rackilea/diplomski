@Override
@Autowired
@Qualifier("name") // or @Resource("name")
setBean(BeanAbstract bean) {
    this.bean=bean;
}