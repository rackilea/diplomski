...
Node currNode = first;
Node prevNode = null;

public void remove()
  {
    if(first != null)
    {
      if(currNode.getNext() == first)
      {
        first = null;
      }
    }
    else
    {
      prevNode = currNode;
      currNode = currNode.getNext();
    } 
  }