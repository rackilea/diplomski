while(temp.next != null){
    if(temp.data != temp2.data || temp2.next == null){
        equal = 0;
        break;
    }
    temp = temp.next;
    temp2 = temp2.next;
}
if(temp2.next != null){
    equal = 0;
}