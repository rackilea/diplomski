public void addMusic (MusicList musics, Music music)
{
  Node node = new Node();
  node.value = music;

  if (musics.head == null)
  {
    // list is empty
    musics.head = node;
    musics.tail = node;
  }
  else if (music.position > musics.tail.value.position)
  {
    // add at the end

    // update "pointers"
    musics.tail.next = node;
    node.prev = musics.tail;

    // add the new element at the end of the list
    musics.tail = node;
  }
  else
  {
    // search for the insertion position
    Node current = musics.head;
    Node previous = current;
    while (current != null)
    {
      if (current.value.position > music.position)
      {
        node.next = current;
        current.prev = node;
        node.prev = previous;
        previous.next = node;
        break;
      }
      previous = current;
      current = current.next;
    }
  }
}