public <E> List<E> getList(KEY key, Class<? extends E> elementClass)
{
  Object o = getObj(key);
  if ( ! (o instanceof List) ) throw new RuntimeException("Not a list value");
  List l = (List)o;
  if ( l.size() > 0 && !elementClass.isAssignableFrom( l.get(0) ) ) throw new RuntimeException("List element not valid type");

  return (List<E>)l;
}