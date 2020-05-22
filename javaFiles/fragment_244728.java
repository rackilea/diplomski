public interface Searchable {
    public String getIndexPath();
}

public interface PhraseSearchable extends Searchable {
    public default void phraseSearch() {
        String indexPath = getIndexPath();
        // do the search
    }
}

public interface TermSearchable extends Searchable {
    public default void termSearch() {
        String indexPath = getIndexPath();
        // do the search
    }
}

public interface CategorySearchable extends Searchable {
    public default void categorySearch() {
        String indexPath = getIndexPath();
        // do the search
    }
}