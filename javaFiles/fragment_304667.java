public void product()
    {
      product(head);   
    }
    public int product(Node head)
    {
      if(head == null)
      {
        return 1;
      }
      else
      {
        int data = head.getData() * product(head.getNext());
        head.setData(data);
        return data;
      }
    }