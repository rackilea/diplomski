public  void add(T x)
    {
        this.current.value=x;
        this.current.next=null;
        last.next=this.current;
        last=this.current;
        if(no==0)
            head=this.current;
        no++;
    }
    public  T remove()
    {

        node<T> y=head;
        while(y.next.next!=null)
        {
            y=y.next;
        }
        T z =y.next.value;
        y.next=null;
        last=y;
        return z;   
    }