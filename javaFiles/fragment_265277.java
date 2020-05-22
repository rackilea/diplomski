public class KeyedItem {
     private final String key;
     private final Object value;
     public KeyedItem(String key, Object value) {
         this.key = key;
         this.value = value;
     }
}
...
private String buildParamaters(KeyedItem[] arguments) {
    ...
}
...
KeyedItem[] arguments = new KeyedItem[] {
    new KeyedItem("key1", 25)
,   new KeyedItem("key2", "a string")
,   new KeyedItem("key3", items)
};