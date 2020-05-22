@XmlRootElement
public class MyHashMap {
    private boolean dirty = false;
    private Map<String,MyObject> str2obj;
    private List<MyObject> myObjects = new ArrayList<>();

    @XmlElement(name = "MyObject")
    List<MyObject> getMyObjects(){
        dirty = true;
        return myObjects();
    }

    // variant 1: expose str2obj
    @XmlTransient
    public Map<String,MyObject> getStr2Obj(){
        if( dirty ) rebuild();
        return str2obj;
    }

    private void rebuild(){
        str2obj.clear();
        for( MyObject myObject: myObjects ){
            str2obj.put(mmyObject.getName(), myObject );
        }
        dirty = false;
    }

    // variant 2: delegate put, get, and other methods
    // use the same approach
}