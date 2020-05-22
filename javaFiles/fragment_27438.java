for(Customer customer:customerArray){
    if(customer instanceof Customer){
        Customer e = (Customer)customer;
        //Do your work here...
    }

    if(customer instanceof CustomerExtended){
        CustomerExtended f = (CustomerExtended)customer;
        //Access number:
        System.out.println(f.number);
    }
}