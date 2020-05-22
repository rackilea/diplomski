// MyListOfMaps.java
public class MyListOfMaps extends ArrayList<HashMap<String, Object>> {
    // constructors, additional methods
}

// ChorkeProcessorImpl.java
@Component("chorkeProcessor")
public class ChorkeProcessorImpl implements ChorkeProcessor{

    @Override
    public void process(Exchange exchange) throws Exception {
        MyListOfMaps list =  exchange.getIn().getBody(MyListOfMaps.class);

        for (HashMap<String, Object> map : list) {
            for (String key : map.keySet()) {
               Object value= map.get(key);
               //TODO
            }
        }
    }
}