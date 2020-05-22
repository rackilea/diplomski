abstract class Parameter {
    private String name;

    public Parameter(String name) {
        this.name = name;
    }

    public abstract Object parse(String s);
}

class IntParameter extends Parameter {
    public static final IntParameter ANSWER = new IntParameter("answer");
    // Add more options here.

    public IntParameter(String name) { super(name); }

    public Object parse(String s) {
        return Integer.parseInt(s);
    }
}

class Parameters {
    private Map<Parameter, Object> params = new HashMap<Parameter, Object>();

    public int get(IntParameter p) {
        return (Integer)params.get(p);
    }

    public void put(IntParameter p, int value) {
        params.put(p, value);
    }

    public void putString(Parameter p, String value) {
        params.put(p, p.parse(value));
    }
}