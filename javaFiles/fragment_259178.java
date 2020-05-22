/**
 * Compute the value of an article.
 * @param lc a dictionary of lowercase words to their value
 * @param article the article to be evaluated
 */
static double evaluate(Map<String, Double> lc, Article article)
{
  return
      Stream.of(article.getTitle(), article.getAbstractText(), article.getText())
      .flatMap(s -> Arrays.stream(s.toLowerCase().split(" ")))
      .mapToDouble(k -> lc.getOrDefault(k, 0D))
      .sum();
}