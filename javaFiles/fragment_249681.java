public class GroceryIterator implements Iterator<GroceryItem>
{
  private GroceryItem[] items;
  private int currentElement = 0;

  public GroceryIterator(GroceryItem[] items)
  {
    this.items = items;
  }

  public GroceryItem next() // implement this
  public void remove() // implement this
  public boolean hasNext() // implement this
}