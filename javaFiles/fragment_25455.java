public class Contact {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                '}';
    }
}