public class ReviewIndex extends AbstractSearchable implements CategorySearchable {
    public ReviewIndex() {
        super("./review_index/");
    }
}
public class TipIndex extends AbstractSearchable implements PhraseSearchable, TermSearchable {
    public ReviewIndex() {
        super("./review_index/");
    }
}