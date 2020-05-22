package forum10972195;

public class EnumBean {

    int ordinal;
    String name;

    public EnumBean() {

    }

    public EnumBean(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}