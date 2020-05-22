ItemInfo obj = new ItemInfo(name, rfidTag, initPosition, initPosition, price);
ItemInfoNode temp = new ItemInfoNode();
temp.setInfo(obj);

if(head == null){
  head = tail = cursor = tmp;
}

else{
  if(cursor == tail)
  {
    cursor.setNext(tmp);
    tmp.setPrev(cursor);
    tail = tmp;
  }
  else
  {
    tmp.setNext(cursor.getNext());
    tmp.setPrev(cursor);

    cursor.getNext().setPrev(tmp);
    cursor.setNext(tmp);
  }
}

listCount++;