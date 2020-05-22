public class Hat
{
  public ArrayList convert(String s)
  {
    Object t = s;
    ArrayList list = new ArrayList();
    list.add(t);
    return list;
  }
}

Hat h = new Hat();
ArrayList iList = h.convert("hello");