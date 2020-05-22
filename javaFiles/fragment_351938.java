public class AnagramGenerator
{
  private Map<String, Collection<String>> indexedDictionary;

  public AnagramGenerator(List<String> dictionary)
  {
    this.indexedDictionary = index(dictionary);
  }

  public Collection<String> getAnagrams(String word)
  {
    return indexedDictionary.get(sort(word));
  }


  private Map<String, Collection<String>> index(List<String> dictionary)
  {
    MultiMap<String, String> indexedDictionary = HashMultimap.create();

    for (String word : dictionary)
    {
      indexDictionary.put(sort(word), word);
    }

    return indexedDictionary.asMap();
  }

  private String sort(String word) 
  {
    List<Character> sortedCharacters= Arrays.asList(word.toCharArray());
    Collections.sort(sortedCharacters);

    StringBuilder builder = new StringBuilder();
    for (Character character : sortedCharacters)
    {
      builder.append(character);
    }

    return builder.toString();
  }
}