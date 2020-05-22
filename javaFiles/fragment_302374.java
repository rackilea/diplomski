@Component("MyPrototypeScopedBeanName")
 @Scope(value = "prototype")
 @ManagedResource     
 public class MyPrototypeScopedBeanName implements SelfNaming

 @Autowired
 MBeanExporter exporter;
 .
 .
 @PostConstruct
 private void init() throws Exception {
    exporter.registerManagedResource(this);
 }
 .
 .
 .

 @Override
 public ObjectName getObjectName() throws MalformedObjectNameException {
     return new ObjectName("com.foobar", "name", this.toString());
 }