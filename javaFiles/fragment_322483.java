customers.clear();
for(Customer newCustomer: result){
   if(newCustomer.user_id != 3){
       customers.add(newCustomer);
   }
}