class Person {
   String name;
   Date birthday;

   @Override
   public boolean equals(Object o){
       //simplified equals implementation, this does not fulfill equals contract!
       return name.equals(((Person)o).name);
   }
}

//true subtype, same behaviour
class Employee extends Person {
   long departmentId;
}

//not a true subtype, different behaviour -> equals
class Customer extends Person {
   long customerId;
   Date lastContact;
   String city;

   public boolean equals(Object o){
       //simplified equals implementation, this does not fulfill equals contract!
       return customerId.equals(((Customer)o).customerId);
   }
}