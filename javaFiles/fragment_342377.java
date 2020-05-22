@Service
public class DataServiceResolver{

    @Autowired
    private DataService classA;

    @Autowired
    private DataService classB;

    @Autowired
    private DataService classC;

    public DataService resolve(Whatever whatever) {
         //process your input and find the enum dataSource;
         DataSource datasource = process(file);
         DataService dataService;
         switch datasource {
           case A:
              dataService = classA;
              break;
           case B:
              dataService = classB;
              break;

           case C:
              dataService = classC;
              break;
           default:
              dataService = classB;
          }
     return dataService

    }
}