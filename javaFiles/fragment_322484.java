ListIterator<Customer> iter = customers.listIterator();
while(iter.hasNext()){
    if(iter.next().user_id == 3){
         iter.remove();
     }
}