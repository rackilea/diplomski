public class ABeanAdapterList extends XmlAdapter<ABeanWrapper, Abean> {

    public int i = 0;

    private Map<Abean, String> unmarshall = new HashMap<Abean, String>();
    private Map<String, Abean> marshall = new HashMap<String, Abean>();


    @Override
    public Abean unmarshal(ABeanWrapper v) throws Exception {
        marshall.put(v.id, v.abean);
        return v.abean;
    }

    @Override
    public ABeanWrapper marshal(Abean v) throws Exception {
        ABeanWrapper beanWrapper = new ABeanWrapper();
        beanWrapper.abean = v;
        beanWrapper.id = String.valueOf(i++);
        unmarshall.put(beanWrapper.abean , beanWrapper.id);
        return beanWrapper;
    }

    public String getId(Abean abean) {
        return unmarshall.get(abean);
    }

    public Abean getAbean(String id) {
        return marshall.get(id);
    }
}