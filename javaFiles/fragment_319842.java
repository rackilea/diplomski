@Stateless
@WebService
public class WebserviceBean {

@Inject
private StatefullSingleton ejb;

public void addvalue(String sessionId, String value) {
    ejb.addValue(sessionId, value);
}

public List<String> loadValues(String sessionId) {
    return ejb.loadValues(sessionId);
}