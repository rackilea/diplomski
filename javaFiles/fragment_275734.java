import dreambot.libs.Library;

public class Helper<T extends Library> {
    private T lib;
    private Class<T> name;

    public Helper(Class<T> name, Library lib) {
        this.name = name;
        this.lib = lib;
    }

    public Class<T> getName() { return name; }
    public T getLib() {
        return lib;
    }
}