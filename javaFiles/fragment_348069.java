public class CanonicalObject {
    public static HashMap<String,CannicalObject> canons = new HahMap<~>();
    public String name;
    private CanonicalObject(String name) { 
        this.name = name;            
        canons.put(name, this);
    }
    public static synchronized CanonicalObject getCanonicalInstance(String name) {            
        CanonicalObject co = canon.get(name);
        return co == null ? new CanonicalObject(name) : co;
    }
}