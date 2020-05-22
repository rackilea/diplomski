public class B {

    private static final List<SpecialItem> DEFAULT_ITEM_LIST = 
        new ArrayList<>(Arrays.asList(new SpecialItem()));

    public SampleClass(int value1, List<SpecialItem> itemList) {
        super(value1, itemList);
    }

    public SampleClass(int value1) {
        this(value1, DEFAULT_ITEM_LIST);
    }
}