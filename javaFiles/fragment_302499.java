public static int pop(){
    if(head==null){
        return 0;
    }
    else{
        Node temp=head;
        head = head.next;
        int a=temp.data;
        temp=null;
        return a;
    }
}