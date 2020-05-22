while(temp != null){
    if(temp2 == null || temp.data != temp2.data){
        equal = 0;
        break;
    }
    temp = temp.next;
    temp2 = temp2.next;
}
if(temp2 != null){
    equal = 0;
}