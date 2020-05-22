public void add(Customer customer){
    Customer temp = customer;
    if(ptr==null){
        ptr = temp;
    }else{
        Customer runner = ptr;    
        // go over the items of the list until you reach the 
        // last item (its "next" field is set to null)             
        while(runner.next != null){ 
            runner= runner.next;
        }
        // now set the customer as the last item
        runner.next= temp;
    }       
}