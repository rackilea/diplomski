// Ignore fields "dt" and "vt"
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyType {
    // Ideally these should use getters/setters
    public int rd;
    public String td;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyType) {
            MyType t = (MyType)obj;
            return t.rd == this.rd
                    && Objects.equals(t.td, this.td);
        }
        return false;
    }

    // hashCode() should always be overriden alongside equals()
    @Override
    public int hashCode() {
        return Objects.hash(rd, td);
    }
}