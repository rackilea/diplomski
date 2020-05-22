@Root(name="keys")
public class KeyList {

    @ElementList(inline=true, entry="key")
    private List<Key> keys;

    public List<Key> getKeys() {
       return keys;
    }
}