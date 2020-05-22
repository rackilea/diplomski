while(temp != null && temp2 != null){
    if(temp.data.equals(temp2.data)){
        return false;
    }
    temp = temp.next;
    temp2 = temp2.next;
}
return temp == temp2;