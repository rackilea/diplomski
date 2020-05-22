public final class Contact {

    private final String number;
    private final String name;

    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String number() { return number; }

    public String name() { return name; }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Contact))
            return false;
        Contact that = (Contact) object;
        return that.number.equals(number) && that.name.equals(name);
    }

    @Override
    public int hashCode() {
        return number.hashCode() ^ name.hashCode();
    }
}