public void insertBefore(String later, String name){
        if(head==null){
            head = new LinkedListNode(name,null);
        }
        else if(head.getName()==later){
            LinkedListNode newNode = makeNode(name);
            newNode.setNext(head);
            head=newNode;   
        }
        else{
            LinkedListNode current = head;
            while(current.getNext().getName()!=later){
                current=current.getNext();
            }
            LinkedListNode newNode = makeNode(name); // create the new node
            newNode.setNext(current.getNext());    
            current.setNext(newNode);
        }
    } // end of insertBefore()