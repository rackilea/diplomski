@Required
@Enumerated(EnumType.STRING)
public GenderEnum myenum;


public enum GenderEnum {

    M ("Male"),
    F ("Female");

    String label;

    CastType(String label) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.label;
    }
}