@Componet
class Container{

    @Autowired
    List<interfaceA> container;

    @PostConstruct
    public void init()
    {
        for(obj : container){
            obj.process();
        }
    }
}