public class DummyContent {

    /**
     * An array of sample items.
     */
    private  Context context ;
    public DummyContent(Context context){
        this.context = context ;
        addStaticItem(); 
    }

    public static  List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample items. Key: sample ID; Value: Item.
     */
    public static  Map<String, DummyItem> ITEM_MAP = new HashMap<>(5);

     public void addStaticItem(){
         addItem(new DummyItem("1", R.drawable.ic_launcher, "Item #1", "Author A", "Content A"));
         addItem(new DummyItem("2", R.drawable.ic_launcher, "Item #2", "Author B","Content B"));
         addItem(new DummyItem("3", R.drawable.ic_launcher, "Item #3", "Author C", context.getResources().getString(R.string.text_ok) ));
     }



    private void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public  class DummyItem {
        public  String id;
        public  int photoId;
        public  String title;
        public  String author;
        public  String content;

        public DummyItem(String id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
}