public class Word extends RealmObject {
    private String name;

    @Index
    @Required
    private long nameLength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.nameLength = name == null ? 0 : name.length();
    }
}