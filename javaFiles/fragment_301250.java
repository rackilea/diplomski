class DynamicType {
    private final String name;

    private Map<String, Integer> fields = new HashMap<>();
    private List<Dynamic> instances = new ArrayList<>();

    public DynamicType(String name) {
        this.name = name;
    }

    public Dynamic createInstance() {
        Dynamic d = new Dynamic(this);

        for (int i=0;i<fields.size();i++) {
            d.addField(null); //Some default value for uninitialized fields
        }

        instances.add(d);
        return d;
    }

    public void addField(String name, Object defaultValue) {
        fields.put(name, fields.size());

        for (Dynamic d : instances) {
            d.addField(defaultValue);
        }
    }

    protected Integer getFieldIdx(String name) {
        return fields.get(name);
    }
}

class Dynamic {
    private List<Object> values;
    private DynamicType type;

    protected Dynamic(DynamicType ofType)
    {
        type = ofType;
        values = new ArrayList<>();
    }

    protected void addField(Object value) {
        values.add(value);
    }

    public Object getField(String name) { 
       return values.get(type.getFieldIdx(name)); 
    }

    public void setField(String name, Object value) { 
       return values.set(type.getFieldIdx(name), value); 
    }
}