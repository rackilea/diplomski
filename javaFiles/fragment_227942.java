@Component
public class AnotherController {

private static DataBaseConnectionProvider obj;

@Autowired
public void setDataBaseConnectionProvider(DataBaseConnectionProvider obj) {
    AnotherController.obj = obj;
}}