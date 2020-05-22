//Class HTTPRequest
    public class HTTPRequest<List<String>> {

    private LinkedHashMap<List<List<String>>, Double> tableOfInitProbList = new LinkedHashMap<List<List<String>>, Double>();

    public HTTPRequest(){
        }

    public HTTPRequest(List<List<String>> entry, Double value){
            tableOfInitProbList.put(entry, value);
        }

    public void putListHTTPCharTable(List<List<String>> uri, Double value){
            tableOfInitProbList.put(uri, value);
        }

    }