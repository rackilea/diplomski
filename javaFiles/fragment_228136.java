public class SiteIDs implements KvmSerializable {

    private List<Integer> Int; //change name of variable, int it's a reserved name

    public SiteIDs() {
    }

    public List<Integer> getInt() {
        return Int;
    }

    public void setInt(List<Integer> anInt) {
        Int = anInt;
    }

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0:
                return Int;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 1;
    }

    @Override
    public void setProperty(int i, Object value) {
        switch (i) {
            case 0:
                this.Int = (List<Integer>) value;
                break;
            default:
                break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i) {
            case 0:
                propertyInfo.name = "int";
                propertyInfo.type = List.class;
                break;
            default:
                break;
        }
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }