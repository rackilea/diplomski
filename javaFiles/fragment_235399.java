public abstract interface GenericParser {
    public void execute();
}

public class GalleryTestParser implements GenericParser {
    public void execute() {
        // Do stuff with item
    }
}

public A(Activity a, List<? extends GenericParser> mStatus) {
    GenericParser item = mStatus.get(0); 
    item.execute();
}