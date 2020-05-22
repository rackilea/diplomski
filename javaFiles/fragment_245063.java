public final class LinkAttribute implements Serializable {
    private static final long serialVersionUID = -472010305643114209L;

    public static final LinkAttribute HREF = new LinkAttribute("href");

    private final String name;

    private LinkAttribute(final String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
       return o instanceof LinkAttribute
              ? name.equals(((LinkAttribute) o).name)
              : false;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return name;
    }
}