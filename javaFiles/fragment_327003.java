@Component("chorkeProcessor")
public class ChorkeProcessorImpl implements ChorkeProcessor{

    @Override
    public void process(Exchange exchange) throws Exception {
        ArrayList<HashMap<String, Object>> list =  exchange.getIn().getBody(ArrayList.class);

        for (HashMap<String, Object> map : list) {
            for (String key : map.keySet()) {
               Object value= map.get(key);
               //TODO
            }
        }
    }
}