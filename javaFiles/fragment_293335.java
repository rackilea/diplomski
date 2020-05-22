if (u.list() == name)
    {
        Node pre = u.getPrevious();
        Node next= u.getNext();

        //Connect next node and previous node
        if(pre != null){
          next.setPrevious(pre);
        }else{
         header=next; 
        }

     //Connect previous node and next node
        if(next != null){
          pre.setNext(next);
        }else{
          pre.setNext(null); 
        }




    }