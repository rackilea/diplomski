import java.util.*;
public class mapTers
{
  public static void main(String[] args)
  {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("ertu", 5);
    map.put("burak", 4);
    map.put("selin", 2);
    map.put("can", 1);
    Integer dizi[] = new Integer[map.size()];
    Set anahtarlar = map.keySet();
    Iterator t = anahtarlar.iterator();
    int a = 0;
    while (t.hasNext())
    {
      dizi[a] = map.get(t.next());
      a++;
    }
    Arrays.sort(dizi);
    for (int i = 0; i < map.size(); i++) 
    {
      t = anahtarlar.iterator();
      while (t.hasNext())
      {
        String temp = (String)t.next();
        if (dizi[i].equals(map.get(temp)))
        {
          System.out.println(dizi[i] + " = " + temp);
        }
      }
    }
  }
}