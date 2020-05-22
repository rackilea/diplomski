public interface BidComponentVisitor {

  void visitArticle(Article article);

  void visitCategory(Category category);
}