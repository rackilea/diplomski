@Component
    @PropertySource(value = {"classpath:properties/props.properties"})
    public class UserParamsImpl{
      @Autowired
      private Environment env;
      @Value("${database.driverClassName}")
      String dbName;

      public void readProp(){
            System.out.println("dbName");
      }

      public void setProp(String name, String val){
       //????????????????
      }

    }