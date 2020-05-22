import dreambot.libs.Library;

public class Helper<T extends Library> {
    private T lib;

    public Helper(Library lib) {
        this.lib = lib;
    }

    public Class<T> getName() { return lib.getClass(); }
    public T getLib() {
        return lib;
    }
}