public abstract interface GenericParser {
    public String getType();
}

public class GalleryTestParser implements GenericParser {
    public String getType() {
        return "gallery";
    }
}

public A(Activity a, List<? extends GenericParser> mStatus) {
    GenericParser item = mStatus.get(0); 
    if (item.getType().equals("gallery")) {
        item = (GalleryTestParser)item;
        // Do stuff with item
    }
}