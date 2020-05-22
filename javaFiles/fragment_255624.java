interface Getter<E, I> 
{
  public E get(I item);
}

public static <T extends Collection<E>, I, E> T convert(T target, Collection<I> source, Getter<E, I> getter)
{
  for (I item : source)
  {
    target.add(getter.get(item));
  }

  return target;
}

List<String> strings = CollectionUtil.convert(
  new ArrayList<String>(someItems.size)
  someItems,
  new Getter<String, MyClass>() 
  {
    public String get(MyClass item)
    {
      return item.toString();
    }
  }
);