public void test()
{
  MusicList myMusic = new MusicList();
  addMusic(myMusic, new Music("Title1", 1));
  addMusic(myMusic, new Music("Title3", 3));
  addMusic(myMusic, new Music("Title2", 2));
  addMusic(myMusic, new Music("Title4", 4));
  System.out.println(myMusic.toString());
}

public class Music
{
  String title;
  int position;

  public Music (String title, int position)
  {
    this.title = title;
    this.position = position;
  }

  @Override
  public String toString()
  {
    return "#" + position + " " + title;
  }
}


public class Node
{
  Music value;
  Node next;
  Node prev;

  @Override
  public String toString()
  {
    return value.toString();
  }
}

public class MusicList
{
  Node head;
  Node tail;

  @Override
  public String toString()
  {
    String result = "My List:";
    Node current = head;
    while (current != null)
    {
      result += "\r\n   " + current;
      current = current.next;
    }
    return result;
  }
}