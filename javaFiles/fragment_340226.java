public void append(String name)
{
  if(names == null)      {
    names = new NameNode(name,null);
  }
  else{
    NameNode tmp = names;
    while(tmp.getNext() != null){
      tmp = tmp.getNext();
    }
    tmp.setNext(new NameNode(name,null));
  }
}