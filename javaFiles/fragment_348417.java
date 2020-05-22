class Reference <T>
{
    public T ref;
}

boolean myFunction(int x, int y, Reference<List> listRef)
{
      listRef.ref = anotherList.subList(....);
      return true;
}