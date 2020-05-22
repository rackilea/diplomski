public void add(Customer customer){
        Customer temp = customer;
        if(ptr==null){
            ptr = temp;
        }else{                                  
            ptr.next = temp;
        }       
    }