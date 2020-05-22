public class ArticleManager {
    private ArticleDatabase database;
    private ArticleCalculator calculator;

    ArticleManager(ArticleObserver observer, boolean flag) {
        // observer is not declared in the test above.
        // flag is not mockable anyway
    }
}