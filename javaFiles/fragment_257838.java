public interface BidComponentVisitor {

  void visitArticle(Article article);

  void enterCategory(Category category);

  void exitCategory(Category category);
}