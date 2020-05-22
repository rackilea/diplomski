public class PrintingVisitor implements BidComponentVisitor {
  private int depth = 0;

  private void printIndent() {
    for (int i = 0; i < depth; i++) {
      System.out.print("  ");
    }
  }

  public void visitArticle(Article article) {
    printIndent();
    System.out.println(article.toString());
  }

  public void enterCategory(Category category);
    printIndent();
    System.out.println(category.toString());
    depth++;
  }

  public void exitCategory(Category category) {
    depth--;
  }
}