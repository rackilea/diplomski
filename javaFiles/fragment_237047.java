@Component
public MapHolder{
    @Autowire
    private List<MyInterface> myAutowireList;

    private Map<Integer, MyInterface> myAutowireMap = new ...;

    public mapHolder(){
    }

    @PostConstruct
    public void init(){
        for(MyInterface ob : myAutowireList){
            myAutowireMap.put(ob.getKey(),ob);
        }
    }
}