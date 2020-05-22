public void Move(int index) {
        if (index >= size) MoveLast();
        else {
            MoveFirst();
            for (int i = 0; i < index-1; i++) MoveNext();  //Run loop until (index - 1) so that you can have reference at the node no. 2 (in case of index 2)
        }
    }

 public void Add(T data) {
        if (data == null) throw new NullPointerException();
        else {
            Node<T> temp = new Node<>(data);
            if (Head == null) AddHead(data);
            else {
                if (Current == Tail) {
                    Tail.setNext(temp);
                    Current = Tail = temp;
                } else if (Current == Head) {
                    temp.setNext(Head);
                    Current = Head = temp;
                } else {
                    Node<T> cu = Current.getNext();
                    Current.setNext(temp);
                    temp.setNext(cu);
                    Current = cu; //Recently added node
                }
            }
            size++;
        }
    }