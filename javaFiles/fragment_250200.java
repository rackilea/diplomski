public class Class_1 implements IQRack {

    private List<IAdant> adan = new ArrayList<IAdant>();

    public Class_1(IAdant i) {
        this.put(i);
    }

    void put(IAdant Show) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

public class IAdant {

    Boolean bValue;
    String sValue;
    Integer iValue;

    public IAdant(Object o) {
        if (o.getClass().isInstance(new Integer(1))) {
            iValue = (Integer) o;
        } else if (o.getClass().isInstance(false)) {
            bValue = (Boolean) o;
        } else if (o.getClass().isInstance("")) {
            sValue = (String) o;
        }
    }
}