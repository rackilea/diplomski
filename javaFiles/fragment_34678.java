@Resource(name = "dataService")
private Driver dataService;

private List<Driver> drivers;

@PostConstruct
public void setup(){
    drivers = new ArrayList<Driver>();
    drivers.add(dataService);
}