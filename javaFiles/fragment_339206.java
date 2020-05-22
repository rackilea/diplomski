public abstract class ListPropertyGetter<R,T>
{
  /** Given a source object, returns some property of type R. */ 
  public abstract R get(T source);

  /** Given a list of objects, use the "get" method to retrieve a single property
      from every list item and return a List of those property values. */
  public final List<R> getListOfProperties(List<T> list)
  {
    List<R> ret = new ArrayList<R>(list.size());
    for(T source : list)
    {
      ret.add(get(source));
    }
    return ret;
  }
}