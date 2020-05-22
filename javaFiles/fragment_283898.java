@Value("${awesomeController}")
private String myControllerName;

@PostConstruct
public void init(){
   AnotherController myController = (AnotherController) appContext.getBean(myControllerName);
}