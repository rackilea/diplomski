public class StringArrayList {
    private int size = 0;
    private String[] strings;

    // Constructors
    public StringArrayList() {
        this(0);
    };
    public StringArrayList(int initialCapacity){
        String[] innerStrings = new String[initialCapacity];
        this(innerStrings);
    }
    public StringArrayList(String[] strings){
        this.strings = strings;
    }

    public int size() {
        return size;
    }

    public String get(int index){
        return strings[index];
    }

    public boolean add(String content){
        if(size == strings.length) {
            String[] newStrings = new String[size+10];
            for(int i = 0; i < size; i++) {
                newStrings[i] = strings[i];
            }
            strings = newStrings;
        }
        strings[size++] = content;
        return true;
    }
}