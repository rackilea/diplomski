public class MakesHashMapsSlow {

    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MakesHashMapsSlow other = (MakesHashMapsSlow) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        if (value == null || value.isEmpty()) {
            return 0;
        } else {
            return value.charAt(0);
        }
    }
}