/**
 * Create a copy of the dictionary with all keys in lower case.
 * @param lc a dictionary of lowercase words to their value
 * @param article the article to be evaluated
 */
static Map<String, Double> convert(Map<String, Double> dictionary) 
{
  return
      dictionary.entrySet().stream()
      .collect(Collectors.toMap(e -> e.getKey().toLowerCase(), 
               Map.Entry::getValue, 
               (p, q) -> p + q));
}