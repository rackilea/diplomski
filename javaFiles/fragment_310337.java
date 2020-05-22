@Component public class PrometheusMonitor {

 @Autowired
 public PrometheusMonitor(MeterRegistry registry, MyDatabase mydb) {
     meterRegistry = registry;

     assertNotNull(mydb);

     // rest of code